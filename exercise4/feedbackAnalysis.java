import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FeedbackAnalysis {
    public static void main(String[] args) {
        List<Feedback> feedbacks = new ArrayList<>();
        feedbacks.add(new Feedback("1", "Alice", 5, "Great service!"));
        feedbacks.add(new Feedback("2", "Bob", 3, "Okay experience."));
        feedbacks.add(new Feedback("3", "Charlie", 1, "Very poor service."));

        // Define feedback filter for positive ratings
        FeedbackFilter positiveFeedbackFilter = feedback -> feedback.getRating() >= 4;

        // Process and count positive feedback
        long positiveCount = feedbacks.stream()
                .filter(positiveFeedbackFilter::filter)
                .peek(System.out::println)
                .count();
        System.out.println("Positive Feedback Count: " + positiveCount);

        // Map to extract customer names and comments
        List<String> customerComments = feedbacks.stream()
                .filter(positiveFeedbackFilter::filter)
                .map(feedback -> feedback.getCustomerName() + ": " + feedback.getComments())
                .collect(Collectors.toList());

        customerComments.forEach(System.out::println);
    }
}
