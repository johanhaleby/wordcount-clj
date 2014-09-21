(ns word-count.wordcount-test
  (:require [midje.sweet :refer :all]
            [word-count.wordcount :refer :all]))

(fact "splits words on whitespace"
      (gather-words "A test is a test") => {"a" 2 "test" 2 "is" 1})

(fact "removes comma"
      (gather-words "A test,. is a test,") => {"a" 2 "test" 2 "is" 1})

(fact "removes punctuation"
      (gather-words "A test. is a test.") => {"a" 2 "test" 2 "is" 1})

(fact "removes exclamation mark"
      (gather-words "A test! is a test") => {"a" 2 "test" 2 "is" 1})

(fact "removes new line"
      (gather-words "A test\n is a test") => {"a" 2 "test" 2 "is" 1})

(fact "removes question mark"
      (gather-words "A test? is? a test") => {"a" 2 "test" 2 "is" 1})

(fact "removes qoute"
      (gather-words "A \"test\" is a test") => {"a" 2 "test" 2 "is" 1})

(fact "removes tab"
      (gather-words "A test\t\t is a test") => {"a" 2 "test" 2 "is" 1})

(fact "handles puncation correctly"
      (gather-words "A test,is a test") => {"a" 2 "test" 2 "is" 1})
