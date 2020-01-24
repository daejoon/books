package com.ddoong2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProfileTest {

    private Profile profile;
    private Question question;
    private Criteria criteria;

    @Before
    public void create() throws Exception {
        profile = new Profile("Bull Hockey, Inc.");
        question = new BooleanQuestion(1, "Got bonuses?");
        criteria = new Criteria();
    }

    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
        // given
        profile.add(new Answer(question, Boolean.FALSE));
        criteria.add(new Criterion(new Answer(question, Boolean.TRUE), Weight.MustMatch));

        // when
        boolean matches = profile.match(criteria);

        // then
        assertFalse(matches);
    }

    @Test
    public void matchAnswersTrueForAnyDontCareCriteria() {
        // given
        profile.add(new Answer(question, Boolean.FALSE));
        criteria.add(new Criterion(new Answer(question, Boolean.TRUE), Weight.DontCare));

        // when
        boolean matches = profile.match(criteria);

        // then
        assertTrue(matches);
    }
}