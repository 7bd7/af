package ee.brightapps.af;

import java.io.Serializable;
import java.util.List;

public class AfSerializableList<T extends Serializable> implements Serializable {

    private List<T> mList;

    public AfSerializableList(List<T> list) {
        mList = list;
    }

    public List<T> get() {
        return mList;
    }

}
