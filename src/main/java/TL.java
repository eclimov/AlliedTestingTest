import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Edik on 09.05.2017.
 */
public class TL implements ITestListener {
    PrintWriter writer = new PrintWriter("test_report.html", "UTF-8");
    int indexCounter, successCounter = 0, failCounter = 0, skipCounter = 0;
    long startTime;

    public TL() throws FileNotFoundException, UnsupportedEncodingException {
        indexCounter = 0;
    }

    //Method for outputting reporter's log
    private void writeOutput(ITestResult result){
        //Each item in new line
        for (String s : Reporter.getOutput(result)) {
            writer.println(s);
        }
    }

    //Processing new row of report table
    public void writeRow(ITestResult iTestResult, String color){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime());
        //Setting row color and outputting cells
        writer.println("bgcolor='"+color+"'>" +
                "           <td>"+indexCounter+"</td>" +
                "           <td>"+iTestResult.getName()+"</td>" +
                "           <td>"+timeStamp+"</td>" +
                "           <td style='text-align: left;'>"+(System.nanoTime() - startTime)/1000000+"</td>" +
                "           <td>");
        writeOutput(iTestResult);
        //End row
        writer.println("</td>" +
                "</tr>");
    }

    public void onTestStart(ITestResult iTestResult) {
        indexCounter++;
        //Start new row
        writer.println("<tr ");
        startTime = System.nanoTime();
    }

    public void onTestSuccess(ITestResult iTestResult) {
        successCounter++;
        //Green color for successful tests
        String color = "#b5ff4b";
        //Processing row
        writeRow(iTestResult, color);
    }

    public void onTestFailure(ITestResult iTestResult) {
        failCounter++;
        //Red color for failed tests
        String color = "#ff8787";
        //Processing row
        writeRow(iTestResult, color);
    }

    public void onTestSkipped(ITestResult iTestResult) {
        skipCounter++;
        //Grey color for skipped tests
        String color = "#b5b5b5";
        //Processing row
        writeRow(iTestResult, color);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        //Yellow color for partially-successful tests
        String color = "#f5f2a1";
        //Processing row
        writeRow(iTestResult, color);
    }

    public void onStart(ITestContext iTestContext) {
        //On test start generating static part of our HTML report
        writer.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">" +
                "   <head>\n" +
                "       <title>Test report</title>\n" +
                "   </head>" +
                "   <body>" +
                "       <table border='2' style='border-collapse: collapse;'>" +
                "           <th>№</th>" +
                "           <th>Name</th>" +
                "           <th>Date/Time</th>" +
                "           <th>Execution Time(ms)</th>" +
                "           <th>Details</th>");
    }

    public void onFinish(ITestContext iTestContext) {
        //On test finish, closing all unclosed tags. Finishing HTML report.
        writer.println("" +
                "       </table>" +
                "       <b><p>Total tests: " + (successCounter + failCounter + skipCounter) +
                "       <p>Sucessfull tests: " + successCounter +
                "       <p>Failed tests: " + failCounter +
                "       <p>Skipped tests: " + skipCounter + "</b>" +
                "   </body>\n" +
                "</html>");

        writer.close();
    }
}