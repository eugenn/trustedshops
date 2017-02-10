package com.trustshops.service;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Properties;

/**
 * Created by eugennekhai on 03/11/2016.
 */
@Component
public class Annotator {
    private StanfordCoreNLP pipeline;

    public Annotator() {
        Properties props = new Properties();

        props.put("annotators", "tokenize,ssplit,pos,lemma,ner,parse");
        props.put("tokenize.language", "de");
        props.put("pos.model", "edu/stanford/nlp/models/pos-tagger/german/german-hgc.tagger");
        props.put("ner.model", "edu/stanford/nlp/models/ner/german.conll.hgc_175m_600.crf.ser.gz");
        props.put("ner.applyNumericClassifiers", "false");
        props.put("ner.useSUTime", "false");
        props.put("parse.model", "edu/stanford/nlp/models/lexparser/germanFactored.ser.gz");
        props.put("depparse.model", "edu/stanford/nlp/models/parser/nndep/UD_German.gz");
        props.put("depparse.language", "german");

        pipeline = new StanfordCoreNLP(props);


    }

    public List<CoreLabel> tokenAnnotations(Annotation annotation) {
        return annotation.get(CoreAnnotations.TokensAnnotation.class);

    }

    public Annotation annotation(String text) {
        Annotation document = new Annotation(text);

        pipeline.annotate(document);
        return document;
    }

}
