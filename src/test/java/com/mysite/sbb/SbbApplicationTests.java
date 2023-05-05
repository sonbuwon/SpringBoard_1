package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
    private AnswerRepository answerRepository;
	
	@Transactional
	@Test
	void jpaTest() {
		Optional<Question> oq = this.questionRepository.findById(3);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        
        List<Answer> aList = q.getAnswerList();
        Answer a = aList.get(0);
        assertEquals(1, a.getId());
	}
}
