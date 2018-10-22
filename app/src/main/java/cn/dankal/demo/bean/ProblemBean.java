package cn.dankal.demo.bean;

import java.util.List;

public class ProblemBean {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private List<QuestionsBeanX> questions;

    public List<QuestionsBeanX> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionsBeanX> questions) {
        this.questions = questions;
    }

    public static class QuestionsBeanX {
        /**
         * questions : [{"title":"路程问题00","uuid":"32f63b15285a11e883c50242c0a82022"},{"title":"路程问题01","uuid":"32f63b15285a11e883c50242c0a82023"}]
         * type : 路程运费问题
         */

        private String type;
        private List<QuestionsBean> questions;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<QuestionsBean> getQuestions() {
            return questions;
        }

        public void setQuestions(List<QuestionsBean> questions) {
            this.questions = questions;
        }

        public static class QuestionsBean {
            /**
             * title : 路程问题00
             * uuid : 32f63b15285a11e883c50242c0a82022
             */

            private String title;
            private String uuid;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }
        }
    }
}
