package Question_3;

import java.util.List;

class ProcessingThread extends Thread {
    private List<Node> node;

    public ProcessingThread(List<Node> node) {
        this.node = node;
    }

    @Override
    public void run() {
        for (Node node : node) {
            // Process node
        }
    }
}
