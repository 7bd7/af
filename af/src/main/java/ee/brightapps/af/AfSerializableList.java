package ee.brightapps.af;

import java.io.Serializable;
import java.util.List;

/**
 * Class allows to serialize List of Serializable objects as <b>one</b> Serializable object.
 * @param <T> custom class, <b>should implement Serializable</b>
 */
public class AfSerializableList<T extends Serializable> implements Serializable {

    private List<T> mList;

    public AfSerializableList(List<T> list) {
        mList = list;
    }

    /**
     * @return the wrapped List of Serializable objects
     */
    public List<T> get() {
        return mList;
    }

}
