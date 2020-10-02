package bolts;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

public class AggregateException extends Exception {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private List<Throwable> f3184a;

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        int i = -1;
        for (Throwable printStackTrace : this.f3184a) {
            printStream.append("\n");
            printStream.append("  Inner throwable #");
            i++;
            printStream.append(Integer.toString(i));
            printStream.append(": ");
            printStackTrace.printStackTrace(printStream);
            printStream.append("\n");
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        int i = -1;
        for (Throwable printStackTrace : this.f3184a) {
            printWriter.append("\n");
            printWriter.append("  Inner throwable #");
            i++;
            printWriter.append(Integer.toString(i));
            printWriter.append(": ");
            printStackTrace.printStackTrace(printWriter);
            printWriter.append("\n");
        }
    }
}
