package synchronize;

public class StaticSynchronizedExchanger {
    protected Object object = null;

    public synchronized Object getObject() {
        return this.object;
    }

    public synchronized void setObject(Object object) {
        this.object = object;
    }

    public Object getObj() {
        synchronized (StaticSynchronizedExchanger.class) {
            return this.object;
        }
    }

    public void setObj(Object obj) {
        synchronized (StaticSynchronizedExchanger.class) {
            this.object = obj;
        }
    }
}
