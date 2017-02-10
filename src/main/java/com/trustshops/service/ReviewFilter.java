package com.trustshops.service;

import com.trustshops.data.Review;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugennekhai on 10/02/2017.
 */
@Component
public class ReviewFilter {
    private final Annotator annotator;

    @Autowired
    public ReviewFilter(Annotator annotator) {
        this.annotator = annotator;
    }

    public List<Review> apply(List<Review> reviews) {
        List<Review> filtered = new ArrayList<>();

        for (Review review : reviews) {
            Document document = new Document(review.getComment());

            for (Sentence sentence : document.sentences()) {
                String sentTxt = sentence.text();

                Annotation annotation = annotator.annotation(sentTxt);

                for (CoreLabel token : annotator.tokenAnnotations(annotation)) {
                    String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);

                    if (ne.equalsIgnoreCase("I-PER")) {
                        filtered.add(review);
                    }
                }
            }
        }

        return filtered;
    }
}
