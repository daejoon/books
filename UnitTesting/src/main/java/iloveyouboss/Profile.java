package iloveyouboss;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class Profile {
    private Map<String, Answer> answers = new HashMap<>();
    private final String name;
    private int score;


    public Profile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Answer answer) {

        answers.put(answer.getQuestionText(), answer);
    }

    public List<Answer> find(Predicate<Answer> predicate) {

        return answers.values().stream()
                .filter(predicate)
                .collect(toList());
    }

    public boolean match(Criteria criteria) {
        this.score = 0;

        boolean kill = false;
        boolean anyMatches = false;

        for (Criterion criterion : criteria) {
            Answer answer = answers.get(
                    criterion.getAnswer().getQuestionText()
            );
            boolean match =
                    criterion.getWeight() == Weight.DontCare ||
                            answer.match(criterion.getAnswer());

            if (!match && criterion.getWeight() == Weight.MustMatch) {
                kill = true;
            }

            if (match) {
                score += criterion.getWeight().getValue();
            }

            anyMatches |= match;
        }

        if (kill) {
            return false;
        }

        return anyMatches;
    }
}
