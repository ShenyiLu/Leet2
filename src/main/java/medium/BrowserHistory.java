package medium;

import java.util.Stack;

public class BrowserHistory {
    Stack<String> backPage;
    Stack<String> forwardPage;
    String currPage;

    public BrowserHistory(String homepage) {
        backPage = new Stack<>();
        forwardPage = new Stack<>();
        currPage = homepage;
    }

    public void visit(String url) {
        backPage.push(currPage);
        currPage = url;
        forwardPage.removeAllElements();
    }

    public String back(int steps) {
        while (!backPage.isEmpty() && steps > 0) {
            forwardPage.push(currPage);
            currPage = backPage.pop();
            steps--;
        }
        return currPage;
    }

    public String forward(int steps) {
        System.out.println(currPage);
        System.out.println(forwardPage.size());
        while (!forwardPage.isEmpty() && steps > 0) {
            backPage.push(currPage);
            currPage = forwardPage.pop();
            steps--;
        }
        return currPage;
    }
}
