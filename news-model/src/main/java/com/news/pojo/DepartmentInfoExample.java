package com.news.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepartmentInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DepartmentInfoExample() {
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

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(Integer value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(Integer value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(Integer value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(Integer value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<Integer> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<Integer> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(Integer value1, Integer value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNull() {
            addCriterion("department_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("department_name =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("department_name <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("department_name >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("department_name >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("department_name <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("department_name <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("department_name like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("department_name not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("department_name in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("department_name not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("department_name between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("department_name not between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentPhoneIsNull() {
            addCriterion("department_phone is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentPhoneIsNotNull() {
            addCriterion("department_phone is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentPhoneEqualTo(String value) {
            addCriterion("department_phone =", value, "departmentPhone");
            return (Criteria) this;
        }

        public Criteria andDepartmentPhoneNotEqualTo(String value) {
            addCriterion("department_phone <>", value, "departmentPhone");
            return (Criteria) this;
        }

        public Criteria andDepartmentPhoneGreaterThan(String value) {
            addCriterion("department_phone >", value, "departmentPhone");
            return (Criteria) this;
        }

        public Criteria andDepartmentPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("department_phone >=", value, "departmentPhone");
            return (Criteria) this;
        }

        public Criteria andDepartmentPhoneLessThan(String value) {
            addCriterion("department_phone <", value, "departmentPhone");
            return (Criteria) this;
        }

        public Criteria andDepartmentPhoneLessThanOrEqualTo(String value) {
            addCriterion("department_phone <=", value, "departmentPhone");
            return (Criteria) this;
        }

        public Criteria andDepartmentPhoneLike(String value) {
            addCriterion("department_phone like", value, "departmentPhone");
            return (Criteria) this;
        }

        public Criteria andDepartmentPhoneNotLike(String value) {
            addCriterion("department_phone not like", value, "departmentPhone");
            return (Criteria) this;
        }

        public Criteria andDepartmentPhoneIn(List<String> values) {
            addCriterion("department_phone in", values, "departmentPhone");
            return (Criteria) this;
        }

        public Criteria andDepartmentPhoneNotIn(List<String> values) {
            addCriterion("department_phone not in", values, "departmentPhone");
            return (Criteria) this;
        }

        public Criteria andDepartmentPhoneBetween(String value1, String value2) {
            addCriterion("department_phone between", value1, value2, "departmentPhone");
            return (Criteria) this;
        }

        public Criteria andDepartmentPhoneNotBetween(String value1, String value2) {
            addCriterion("department_phone not between", value1, value2, "departmentPhone");
            return (Criteria) this;
        }

        public Criteria andDepartmentIntroIsNull() {
            addCriterion("department_intro is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIntroIsNotNull() {
            addCriterion("department_intro is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIntroEqualTo(String value) {
            addCriterion("department_intro =", value, "departmentIntro");
            return (Criteria) this;
        }

        public Criteria andDepartmentIntroNotEqualTo(String value) {
            addCriterion("department_intro <>", value, "departmentIntro");
            return (Criteria) this;
        }

        public Criteria andDepartmentIntroGreaterThan(String value) {
            addCriterion("department_intro >", value, "departmentIntro");
            return (Criteria) this;
        }

        public Criteria andDepartmentIntroGreaterThanOrEqualTo(String value) {
            addCriterion("department_intro >=", value, "departmentIntro");
            return (Criteria) this;
        }

        public Criteria andDepartmentIntroLessThan(String value) {
            addCriterion("department_intro <", value, "departmentIntro");
            return (Criteria) this;
        }

        public Criteria andDepartmentIntroLessThanOrEqualTo(String value) {
            addCriterion("department_intro <=", value, "departmentIntro");
            return (Criteria) this;
        }

        public Criteria andDepartmentIntroLike(String value) {
            addCriterion("department_intro like", value, "departmentIntro");
            return (Criteria) this;
        }

        public Criteria andDepartmentIntroNotLike(String value) {
            addCriterion("department_intro not like", value, "departmentIntro");
            return (Criteria) this;
        }

        public Criteria andDepartmentIntroIn(List<String> values) {
            addCriterion("department_intro in", values, "departmentIntro");
            return (Criteria) this;
        }

        public Criteria andDepartmentIntroNotIn(List<String> values) {
            addCriterion("department_intro not in", values, "departmentIntro");
            return (Criteria) this;
        }

        public Criteria andDepartmentIntroBetween(String value1, String value2) {
            addCriterion("department_intro between", value1, value2, "departmentIntro");
            return (Criteria) this;
        }

        public Criteria andDepartmentIntroNotBetween(String value1, String value2) {
            addCriterion("department_intro not between", value1, value2, "departmentIntro");
            return (Criteria) this;
        }

        public Criteria andDepartmentTimeIsNull() {
            addCriterion("department_time is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentTimeIsNotNull() {
            addCriterion("department_time is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentTimeEqualTo(Date value) {
            addCriterion("department_time =", value, "departmentTime");
            return (Criteria) this;
        }

        public Criteria andDepartmentTimeNotEqualTo(Date value) {
            addCriterion("department_time <>", value, "departmentTime");
            return (Criteria) this;
        }

        public Criteria andDepartmentTimeGreaterThan(Date value) {
            addCriterion("department_time >", value, "departmentTime");
            return (Criteria) this;
        }

        public Criteria andDepartmentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("department_time >=", value, "departmentTime");
            return (Criteria) this;
        }

        public Criteria andDepartmentTimeLessThan(Date value) {
            addCriterion("department_time <", value, "departmentTime");
            return (Criteria) this;
        }

        public Criteria andDepartmentTimeLessThanOrEqualTo(Date value) {
            addCriterion("department_time <=", value, "departmentTime");
            return (Criteria) this;
        }

        public Criteria andDepartmentTimeIn(List<Date> values) {
            addCriterion("department_time in", values, "departmentTime");
            return (Criteria) this;
        }

        public Criteria andDepartmentTimeNotIn(List<Date> values) {
            addCriterion("department_time not in", values, "departmentTime");
            return (Criteria) this;
        }

        public Criteria andDepartmentTimeBetween(Date value1, Date value2) {
            addCriterion("department_time between", value1, value2, "departmentTime");
            return (Criteria) this;
        }

        public Criteria andDepartmentTimeNotBetween(Date value1, Date value2) {
            addCriterion("department_time not between", value1, value2, "departmentTime");
            return (Criteria) this;
        }

        public Criteria andDepartmentStateIsNull() {
            addCriterion("department_state is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentStateIsNotNull() {
            addCriterion("department_state is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentStateEqualTo(String value) {
            addCriterion("department_state =", value, "departmentState");
            return (Criteria) this;
        }

        public Criteria andDepartmentStateNotEqualTo(String value) {
            addCriterion("department_state <>", value, "departmentState");
            return (Criteria) this;
        }

        public Criteria andDepartmentStateGreaterThan(String value) {
            addCriterion("department_state >", value, "departmentState");
            return (Criteria) this;
        }

        public Criteria andDepartmentStateGreaterThanOrEqualTo(String value) {
            addCriterion("department_state >=", value, "departmentState");
            return (Criteria) this;
        }

        public Criteria andDepartmentStateLessThan(String value) {
            addCriterion("department_state <", value, "departmentState");
            return (Criteria) this;
        }

        public Criteria andDepartmentStateLessThanOrEqualTo(String value) {
            addCriterion("department_state <=", value, "departmentState");
            return (Criteria) this;
        }

        public Criteria andDepartmentStateLike(String value) {
            addCriterion("department_state like", value, "departmentState");
            return (Criteria) this;
        }

        public Criteria andDepartmentStateNotLike(String value) {
            addCriterion("department_state not like", value, "departmentState");
            return (Criteria) this;
        }

        public Criteria andDepartmentStateIn(List<String> values) {
            addCriterion("department_state in", values, "departmentState");
            return (Criteria) this;
        }

        public Criteria andDepartmentStateNotIn(List<String> values) {
            addCriterion("department_state not in", values, "departmentState");
            return (Criteria) this;
        }

        public Criteria andDepartmentStateBetween(String value1, String value2) {
            addCriterion("department_state between", value1, value2, "departmentState");
            return (Criteria) this;
        }

        public Criteria andDepartmentStateNotBetween(String value1, String value2) {
            addCriterion("department_state not between", value1, value2, "departmentState");
            return (Criteria) this;
        }

        public Criteria andDepartmentLikmanIsNull() {
            addCriterion("department_likman is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentLikmanIsNotNull() {
            addCriterion("department_likman is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentLikmanEqualTo(String value) {
            addCriterion("department_likman =", value, "departmentLikman");
            return (Criteria) this;
        }

        public Criteria andDepartmentLikmanNotEqualTo(String value) {
            addCriterion("department_likman <>", value, "departmentLikman");
            return (Criteria) this;
        }

        public Criteria andDepartmentLikmanGreaterThan(String value) {
            addCriterion("department_likman >", value, "departmentLikman");
            return (Criteria) this;
        }

        public Criteria andDepartmentLikmanGreaterThanOrEqualTo(String value) {
            addCriterion("department_likman >=", value, "departmentLikman");
            return (Criteria) this;
        }

        public Criteria andDepartmentLikmanLessThan(String value) {
            addCriterion("department_likman <", value, "departmentLikman");
            return (Criteria) this;
        }

        public Criteria andDepartmentLikmanLessThanOrEqualTo(String value) {
            addCriterion("department_likman <=", value, "departmentLikman");
            return (Criteria) this;
        }

        public Criteria andDepartmentLikmanLike(String value) {
            addCriterion("department_likman like", value, "departmentLikman");
            return (Criteria) this;
        }

        public Criteria andDepartmentLikmanNotLike(String value) {
            addCriterion("department_likman not like", value, "departmentLikman");
            return (Criteria) this;
        }

        public Criteria andDepartmentLikmanIn(List<String> values) {
            addCriterion("department_likman in", values, "departmentLikman");
            return (Criteria) this;
        }

        public Criteria andDepartmentLikmanNotIn(List<String> values) {
            addCriterion("department_likman not in", values, "departmentLikman");
            return (Criteria) this;
        }

        public Criteria andDepartmentLikmanBetween(String value1, String value2) {
            addCriterion("department_likman between", value1, value2, "departmentLikman");
            return (Criteria) this;
        }

        public Criteria andDepartmentLikmanNotBetween(String value1, String value2) {
            addCriterion("department_likman not between", value1, value2, "departmentLikman");
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