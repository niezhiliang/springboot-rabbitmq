package com.niezhiliang.springboot.rabbitmq.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrokerMessageLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BrokerMessageLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMessage_idIsNull() {
            addCriterion("message_id is null");
            return (Criteria) this;
        }

        public Criteria andMessage_idIsNotNull() {
            addCriterion("message_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessage_idEqualTo(String value) {
            addCriterion("message_id =", value, "message_id");
            return (Criteria) this;
        }

        public Criteria andMessage_idNotEqualTo(String value) {
            addCriterion("message_id <>", value, "message_id");
            return (Criteria) this;
        }

        public Criteria andMessage_idGreaterThan(String value) {
            addCriterion("message_id >", value, "message_id");
            return (Criteria) this;
        }

        public Criteria andMessage_idGreaterThanOrEqualTo(String value) {
            addCriterion("message_id >=", value, "message_id");
            return (Criteria) this;
        }

        public Criteria andMessage_idLessThan(String value) {
            addCriterion("message_id <", value, "message_id");
            return (Criteria) this;
        }

        public Criteria andMessage_idLessThanOrEqualTo(String value) {
            addCriterion("message_id <=", value, "message_id");
            return (Criteria) this;
        }

        public Criteria andMessage_idLike(String value) {
            addCriterion("message_id like", value, "message_id");
            return (Criteria) this;
        }

        public Criteria andMessage_idNotLike(String value) {
            addCriterion("message_id not like", value, "message_id");
            return (Criteria) this;
        }

        public Criteria andMessage_idIn(List<String> values) {
            addCriterion("message_id in", values, "message_id");
            return (Criteria) this;
        }

        public Criteria andMessage_idNotIn(List<String> values) {
            addCriterion("message_id not in", values, "message_id");
            return (Criteria) this;
        }

        public Criteria andMessage_idBetween(String value1, String value2) {
            addCriterion("message_id between", value1, value2, "message_id");
            return (Criteria) this;
        }

        public Criteria andMessage_idNotBetween(String value1, String value2) {
            addCriterion("message_id not between", value1, value2, "message_id");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andTry_countIsNull() {
            addCriterion("try_count is null");
            return (Criteria) this;
        }

        public Criteria andTry_countIsNotNull() {
            addCriterion("try_count is not null");
            return (Criteria) this;
        }

        public Criteria andTry_countEqualTo(Integer value) {
            addCriterion("try_count =", value, "try_count");
            return (Criteria) this;
        }

        public Criteria andTry_countNotEqualTo(Integer value) {
            addCriterion("try_count <>", value, "try_count");
            return (Criteria) this;
        }

        public Criteria andTry_countGreaterThan(Integer value) {
            addCriterion("try_count >", value, "try_count");
            return (Criteria) this;
        }

        public Criteria andTry_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("try_count >=", value, "try_count");
            return (Criteria) this;
        }

        public Criteria andTry_countLessThan(Integer value) {
            addCriterion("try_count <", value, "try_count");
            return (Criteria) this;
        }

        public Criteria andTry_countLessThanOrEqualTo(Integer value) {
            addCriterion("try_count <=", value, "try_count");
            return (Criteria) this;
        }

        public Criteria andTry_countIn(List<Integer> values) {
            addCriterion("try_count in", values, "try_count");
            return (Criteria) this;
        }

        public Criteria andTry_countNotIn(List<Integer> values) {
            addCriterion("try_count not in", values, "try_count");
            return (Criteria) this;
        }

        public Criteria andTry_countBetween(Integer value1, Integer value2) {
            addCriterion("try_count between", value1, value2, "try_count");
            return (Criteria) this;
        }

        public Criteria andTry_countNotBetween(Integer value1, Integer value2) {
            addCriterion("try_count not between", value1, value2, "try_count");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andNext_retryIsNull() {
            addCriterion("next_retry is null");
            return (Criteria) this;
        }

        public Criteria andNext_retryIsNotNull() {
            addCriterion("next_retry is not null");
            return (Criteria) this;
        }

        public Criteria andNext_retryEqualTo(Date value) {
            addCriterion("next_retry =", value, "next_retry");
            return (Criteria) this;
        }

        public Criteria andNext_retryNotEqualTo(Date value) {
            addCriterion("next_retry <>", value, "next_retry");
            return (Criteria) this;
        }

        public Criteria andNext_retryGreaterThan(Date value) {
            addCriterion("next_retry >", value, "next_retry");
            return (Criteria) this;
        }

        public Criteria andNext_retryGreaterThanOrEqualTo(Date value) {
            addCriterion("next_retry >=", value, "next_retry");
            return (Criteria) this;
        }

        public Criteria andNext_retryLessThan(Date value) {
            addCriterion("next_retry <", value, "next_retry");
            return (Criteria) this;
        }

        public Criteria andNext_retryLessThanOrEqualTo(Date value) {
            addCriterion("next_retry <=", value, "next_retry");
            return (Criteria) this;
        }

        public Criteria andNext_retryIn(List<Date> values) {
            addCriterion("next_retry in", values, "next_retry");
            return (Criteria) this;
        }

        public Criteria andNext_retryNotIn(List<Date> values) {
            addCriterion("next_retry not in", values, "next_retry");
            return (Criteria) this;
        }

        public Criteria andNext_retryBetween(Date value1, Date value2) {
            addCriterion("next_retry between", value1, value2, "next_retry");
            return (Criteria) this;
        }

        public Criteria andNext_retryNotBetween(Date value1, Date value2) {
            addCriterion("next_retry not between", value1, value2, "next_retry");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeEqualTo(Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThan(Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThan(Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIn(List<Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}