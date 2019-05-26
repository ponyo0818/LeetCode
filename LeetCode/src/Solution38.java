/**
 * 38. Count and Say
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *  n String to print
 * 0 1
 * 1 1 1
 * 2 2 1
 * 3 1 2 1 1
 * ...
 * Base case: n = 0 print "1"
 * for n = 1, look at previous string and write number of times a digit is seen and the digit itself. In this case,
 *
 * digit 1 is seen 1 time in a row... so print "1 1"
 *
 * for n = 2, digit 1 is seen two times in a row, so print "2 1"
 *
 * for n = 3, digit 2 is seen 1 time and then digit 1 is seen 1 so print "1 2 1 1"
 *
 * for n = 4 you will print "1 1 1 2 2 1"
 *
 * 中文解释：
 * 初始值第一行是 1。
 * 第二行读第一行，1 个 1，去掉个字，所以第二行就是 11。
 * 第三行读第二行，2 个 1，去掉个字，所以第三行就是 21。
 * 第四行读第三行，1 个 2，1 个 1，去掉所有个字，所以第四行就是 1211。
 * 第五行读第四行，1 个 1，1 个 2，2 个 1，去掉所有个字，所以第五航就是 111221。
 * 第六行读第五行，3 个 1，2 个 2，1 个 1，去掉所以个字，所以第六行就是 312211。
 * 然后题目要求输入 1 - 30 的任意行数，输出该行是啥。
 *
 *
 * StringBuilder.append() is the default way to append one string to another
 * Recursive Approach
 *
 *
 */
public class Solution38 {
    /**
     *
     * @param n
     * @return string
     */
    public String countAndSay(int n) {
        //the first line
        if (n == 1) {
            return "1";
        }
        //the output of last line
        String last = countAndSay(n - 1);
        //return the output of the current line
        return getNextString(last);

    }

    private String getNextString(String last) {
        if (last.length() == 0) {
            return "";
        }
        //get the times of a certain number's occurrence
        int num = getRepeatNum(last);
        // print the result recursively
        return num + "" + last.charAt(0) + getNextString(last.substring(num));
    }

    //the method to get the occurrence of a number
    private int getRepeatNum(String string) {
        int count = 1;
        char same = string.charAt(0);
        for (int i = 1; i < string.length(); i++) {
            if (same == string.charAt(i)) {
                count++;
            } else {
                break; //if not the same as previous break out of the loop and return count of this number
            }
        }
        return count;
    }

    public static void main (String [] args){
        Solution38 ns = new Solution38();
        System.out.println (ns.countAndSay(8));
    }
}
