package futurenavi.lib.erecyclerview.expandablerecyclerview.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * The backing data object for an {@link ExpandableGroup}
 */
public class ExpandableGroup<T extends Parcelable> implements Parcelable {
    public String title;
    public String type;
    public List<T> items;

    public ExpandableGroup(String title, List<T> items) {
        this.title = title;
        this.type = "-1";
        this.items = items;
    }


    public ExpandableGroup(String title, String type, List<T> items) {
        this.title = title;
        this.type = type;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public List<T> getItems() {
        return items;
    }

    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    @Override
    public String toString() {
        return "ExpandableGroup{" +
                "title='" + title + '\'' +
                ", items=" + items +
                '}';
    }

    protected ExpandableGroup(Parcel in) {
        title = in.readString();
        type = in.readString();
        if (in.readByte() == 0x01) {
            int size = in.readInt();
            items = new ArrayList<T>(size);
            Class<?> type = (Class<?>) in.readSerializable();
            in.readList(items, type.getClassLoader());
        } else {
            items = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(type);
        if (items == null) {
            dest.writeByte((byte) (0x00));
            dest.writeInt(0);
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(items.size());
            final Class<?> objectsType = items.get(0).getClass();
            dest.writeSerializable(objectsType);
            dest.writeList(items);
        }
    }

    @SuppressWarnings("unused")
    public static final Creator<ExpandableGroup> CREATOR =
            new Creator<ExpandableGroup>() {
                @Override
                public ExpandableGroup createFromParcel(Parcel in) {
                    return new ExpandableGroup(in);
                }

                @Override
                public ExpandableGroup[] newArray(int size) {
                    return new ExpandableGroup[size];
                }
            };
}
