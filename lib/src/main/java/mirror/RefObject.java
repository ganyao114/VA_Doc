package mirror;

import java.lang.reflect.Field;

// Field 映射
@SuppressWarnings("unchecked")
public class RefObject<T> {

    // framework 层对应的 Field
    private Field field;

    public RefObject(Class<?> cls, Field field) throws NoSuchFieldException {
        // 获取 framework 中同名字段的 field
        this.field = cls.getDeclaredField(field.getName());
        this.field.setAccessible(true);
    }

    // 获取变量值
    public T get(Object object) {
        try {
            return (T) this.field.get(object);
        } catch (Exception e) {
            return null;
        }
    }
    // 赋值
    public void set(Object obj, T value) {
        try {
            this.field.set(obj, value);
        } catch (Exception e) {
            //Ignore
        }
    }
}