package com.ddoong2;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProfileTest {

    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
        Profile profile = new Profile("Bull Hockey, Inc.");
        Question question = new BooleanQuestion(1, "Got bonuses?");

        Answer profileAnswer = new Answer(question, Boolean.FALSE);
        profile.add(profileAnswer);

        Criteria criteria = new Criteria();
        Answer criteriaAnswer = new Answer(question, Boolean.TRUE);
        Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch);

        criteria.add(criterion);

        boolean matches = profile.match(criteria);
        assertFalse(matches);
    }

    @Test
    public void matchAnswersTrueForAnyDontCareCriteria() {
        Profile profile = new Profile("Bull Hockey, Inc.");
        Question question = new BooleanQuestion(1, "Got milk?");

        Answer profileAnswer = new Answer(question, Boolean.FALSE);
        profile.add(profileAnswer);

        Criteria criteria = new Criteria();
        Answer criteriaAnswer = new Answer(question, Boolean.TRUE);
        Criterion criterion = new Criterion(criteriaAnswer, Weight.DontCare);

        criteria.add(criterion);

        boolean matches = profile.match(criteria);
        assertTrue(matches);
    }
}