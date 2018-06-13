package operatingSystem.Assignment2;

/**
 * Created by parthgodhani on 12/4/17.
 */
public class FIFO {

    private short values[];
    private short IN_POINTER;
    private short OUT_POINTER;

    public FIFO(short number) {
        values = new short[number+1];
        IN_POINTER = 0;
        OUT_POINTER = 0;
    }

    public short getDataSize(){
        return (short) values.length;
    }

    public boolean store(short value) {
        if (!bufferFull()) {
            values[OUT_POINTER++] =(short) value;
            if (OUT_POINTER == values.length) {
                OUT_POINTER = 0;
            }
            return true;
        } else {
            return false;
        }
    }

    public short read() {
        if (IN_POINTER != OUT_POINTER) {
            short value = values[IN_POINTER++];
            if (IN_POINTER == values.length) {
                IN_POINTER = 0;
            }
            return value;
        } else {
            return -1;
        }
    }

    public boolean bufferFull() {
        if (OUT_POINTER + 1 == IN_POINTER) {
            return true;
        }
        if (OUT_POINTER == (values.length - 1) && IN_POINTER == 0) {
            return true;
        }
        return false;
    }
}