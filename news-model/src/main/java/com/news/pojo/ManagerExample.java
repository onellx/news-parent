package com.news.pojo;

import java.util.ArrayList;
import java.util.List;

public class ManagerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ManagerExample() {
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

        public Criteria andManagerIdIsNull() {
            addCriterion("manager_id is null");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNotNull() {
            addCriterion("manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andManagerIdEqualTo(Integer value) {
            addCriterion("manager_id =", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotEqualTo(Integer value) {
            addCriterion("manager_id <>", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThan(Integer value) {
            addCriterion("manager_id >", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("manager_id >=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThan(Integer value) {
            addCriterion("manager_id <", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThanOrEqualTo(Integer value) {
            addCriterion("manager_id <=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdIn(List<Integer> values) {
            addCriterion("manager_id in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotIn(List<Integer> values) {
            addCriterion("manager_id not in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdBetween(Integer value1, Integer value2) {
            addCriterion("manager_id between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("manager_id not between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerNameIsNull() {
            addCriterion("manager_name is null");
            return (Criteria) this;
        }

        public Criteria andManagerNameIsNotNull() {
            addCriterion("manager_name is not null");
            return (Criteria) this;
        }

        public Criteria andManagerNameEqualTo(String value) {
            addCriterion("manager_name =", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotEqualTo(String value) {
            addCriterion("manager_name <>", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameGreaterThan(String value) {
            addCriterion("manager_name >", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameGreaterThanOrEqualTo(String value) {
            addCriterion("manager_name >=", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameLessThan(String value) {
            addCriterion("manager_name <", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameLessThanOrEqualTo(String value) {
            addCriterion("manager_name <=", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameLike(String value) {
            addCriterion("manager_name like", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotLike(String value) {
            addCriterion("manager_name not like", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameIn(List<String> values) {
            addCriterion("manager_name in", values, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotIn(List<String> values) {
            addCriterion("manager_name not in", values, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameBetween(String value1, String value2) {
            addCriterion("manager_name between", value1, value2, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotBetween(String value1, String value2) {
            addCriterion("manager_name not between", value1, value2, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerPasswdIsNull() {
            addCriterion("manager_passwd is null");
            return (Criteria) this;
        }

        public Criteria andManagerPasswdIsNotNull() {
            addCriterion("manager_passwd is not null");
            return (Criteria) this;
        }

        public Criteria andManagerPasswdEqualTo(String value) {
            addCriterion("manager_passwd =", value, "managerPasswd");
            return (Criteria) this;
        }

        public Criteria andManagerPasswdNotEqualTo(String value) {
            addCriterion("manager_passwd <>", value, "managerPasswd");
            return (Criteria) this;
        }

        public Criteria andManagerPasswdGreaterThan(String value) {
            addCriterion("manager_passwd >", value, "managerPasswd");
            return (Criteria) this;
        }

        public Criteria andManagerPasswdGreaterThanOrEqualTo(String value) {
            addCriterion("manager_passwd >=", value, "managerPasswd");
            return (Criteria) this;
        }

        public Criteria andManagerPasswdLessThan(String value) {
            addCriterion("manager_passwd <", value, "managerPasswd");
            return (Criteria) this;
        }

        public Criteria andManagerPasswdLessThanOrEqualTo(String value) {
            addCriterion("manager_passwd <=", value, "managerPasswd");
            return (Criteria) this;
        }

        public Criteria andManagerPasswdLike(String value) {
            addCriterion("manager_passwd like", value, "managerPasswd");
            return (Criteria) this;
        }

        public Criteria andManagerPasswdNotLike(String value) {
            addCriterion("manager_passwd not like", value, "managerPasswd");
            return (Criteria) this;
        }

        public Criteria andManagerPasswdIn(List<String> values) {
            addCriterion("manager_passwd in", values, "managerPasswd");
            return (Criteria) this;
        }

        public Criteria andManagerPasswdNotIn(List<String> values) {
            addCriterion("manager_passwd not in", values, "managerPasswd");
            return (Criteria) this;
        }

        public Criteria andManagerPasswdBetween(String value1, String value2) {
            addCriterion("manager_passwd between", value1, value2, "managerPasswd");
            return (Criteria) this;
        }

        public Criteria andManagerPasswdNotBetween(String value1, String value2) {
            addCriterion("manager_passwd not between", value1, value2, "managerPasswd");
            return (Criteria) this;
        }

        public Criteria andManagerEmailIsNull() {
            addCriterion("manager_email is null");
            return (Criteria) this;
        }

        public Criteria andManagerEmailIsNotNull() {
            addCriterion("manager_email is not null");
            return (Criteria) this;
        }

        public Criteria andManagerEmailEqualTo(String value) {
            addCriterion("manager_email =", value, "managerEmail");
            return (Criteria) this;
        }

        public Criteria andManagerEmailNotEqualTo(String value) {
            addCriterion("manager_email <>", value, "managerEmail");
            return (Criteria) this;
        }

        public Criteria andManagerEmailGreaterThan(String value) {
            addCriterion("manager_email >", value, "managerEmail");
            return (Criteria) this;
        }

        public Criteria andManagerEmailGreaterThanOrEqualTo(String value) {
            addCriterion("manager_email >=", value, "managerEmail");
            return (Criteria) this;
        }

        public Criteria andManagerEmailLessThan(String value) {
            addCriterion("manager_email <", value, "managerEmail");
            return (Criteria) this;
        }

        public Criteria andManagerEmailLessThanOrEqualTo(String value) {
            addCriterion("manager_email <=", value, "managerEmail");
            return (Criteria) this;
        }

        public Criteria andManagerEmailLike(String value) {
            addCriterion("manager_email like", value, "managerEmail");
            return (Criteria) this;
        }

        public Criteria andManagerEmailNotLike(String value) {
            addCriterion("manager_email not like", value, "managerEmail");
            return (Criteria) this;
        }

        public Criteria andManagerEmailIn(List<String> values) {
            addCriterion("manager_email in", values, "managerEmail");
            return (Criteria) this;
        }

        public Criteria andManagerEmailNotIn(List<String> values) {
            addCriterion("manager_email not in", values, "managerEmail");
            return (Criteria) this;
        }

        public Criteria andManagerEmailBetween(String value1, String value2) {
            addCriterion("manager_email between", value1, value2, "managerEmail");
            return (Criteria) this;
        }

        public Criteria andManagerEmailNotBetween(String value1, String value2) {
            addCriterion("manager_email not between", value1, value2, "managerEmail");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneIsNull() {
            addCriterion("manager_phone is null");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneIsNotNull() {
            addCriterion("manager_phone is not null");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneEqualTo(String value) {
            addCriterion("manager_phone =", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneNotEqualTo(String value) {
            addCriterion("manager_phone <>", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneGreaterThan(String value) {
            addCriterion("manager_phone >", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("manager_phone >=", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneLessThan(String value) {
            addCriterion("manager_phone <", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneLessThanOrEqualTo(String value) {
            addCriterion("manager_phone <=", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneLike(String value) {
            addCriterion("manager_phone like", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneNotLike(String value) {
            addCriterion("manager_phone not like", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneIn(List<String> values) {
            addCriterion("manager_phone in", values, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneNotIn(List<String> values) {
            addCriterion("manager_phone not in", values, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneBetween(String value1, String value2) {
            addCriterion("manager_phone between", value1, value2, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneNotBetween(String value1, String value2) {
            addCriterion("manager_phone not between", value1, value2, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerStateIsNull() {
            addCriterion("manager_state is null");
            return (Criteria) this;
        }

        public Criteria andManagerStateIsNotNull() {
            addCriterion("manager_state is not null");
            return (Criteria) this;
        }

        public Criteria andManagerStateEqualTo(String value) {
            addCriterion("manager_state =", value, "managerState");
            return (Criteria) this;
        }

        public Criteria andManagerStateNotEqualTo(String value) {
            addCriterion("manager_state <>", value, "managerState");
            return (Criteria) this;
        }

        public Criteria andManagerStateGreaterThan(String value) {
            addCriterion("manager_state >", value, "managerState");
            return (Criteria) this;
        }

        public Criteria andManagerStateGreaterThanOrEqualTo(String value) {
            addCriterion("manager_state >=", value, "managerState");
            return (Criteria) this;
        }

        public Criteria andManagerStateLessThan(String value) {
            addCriterion("manager_state <", value, "managerState");
            return (Criteria) this;
        }

        public Criteria andManagerStateLessThanOrEqualTo(String value) {
            addCriterion("manager_state <=", value, "managerState");
            return (Criteria) this;
        }

        public Criteria andManagerStateLike(String value) {
            addCriterion("manager_state like", value, "managerState");
            return (Criteria) this;
        }

        public Criteria andManagerStateNotLike(String value) {
            addCriterion("manager_state not like", value, "managerState");
            return (Criteria) this;
        }

        public Criteria andManagerStateIn(List<String> values) {
            addCriterion("manager_state in", values, "managerState");
            return (Criteria) this;
        }

        public Criteria andManagerStateNotIn(List<String> values) {
            addCriterion("manager_state not in", values, "managerState");
            return (Criteria) this;
        }

        public Criteria andManagerStateBetween(String value1, String value2) {
            addCriterion("manager_state between", value1, value2, "managerState");
            return (Criteria) this;
        }

        public Criteria andManagerStateNotBetween(String value1, String value2) {
            addCriterion("manager_state not between", value1, value2, "managerState");
            return (Criteria) this;
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

        public Criteria andManagerNumberIsNull() {
            addCriterion("manager_number is null");
            return (Criteria) this;
        }

        public Criteria andManagerNumberIsNotNull() {
            addCriterion("manager_number is not null");
            return (Criteria) this;
        }

        public Criteria andManagerNumberEqualTo(String value) {
            addCriterion("manager_number =", value, "managerNumber");
            return (Criteria) this;
        }

        public Criteria andManagerNumberNotEqualTo(String value) {
            addCriterion("manager_number <>", value, "managerNumber");
            return (Criteria) this;
        }

        public Criteria andManagerNumberGreaterThan(String value) {
            addCriterion("manager_number >", value, "managerNumber");
            return (Criteria) this;
        }

        public Criteria andManagerNumberGreaterThanOrEqualTo(String value) {
            addCriterion("manager_number >=", value, "managerNumber");
            return (Criteria) this;
        }

        public Criteria andManagerNumberLessThan(String value) {
            addCriterion("manager_number <", value, "managerNumber");
            return (Criteria) this;
        }

        public Criteria andManagerNumberLessThanOrEqualTo(String value) {
            addCriterion("manager_number <=", value, "managerNumber");
            return (Criteria) this;
        }

        public Criteria andManagerNumberLike(String value) {
            addCriterion("manager_number like", value, "managerNumber");
            return (Criteria) this;
        }

        public Criteria andManagerNumberNotLike(String value) {
            addCriterion("manager_number not like", value, "managerNumber");
            return (Criteria) this;
        }

        public Criteria andManagerNumberIn(List<String> values) {
            addCriterion("manager_number in", values, "managerNumber");
            return (Criteria) this;
        }

        public Criteria andManagerNumberNotIn(List<String> values) {
            addCriterion("manager_number not in", values, "managerNumber");
            return (Criteria) this;
        }

        public Criteria andManagerNumberBetween(String value1, String value2) {
            addCriterion("manager_number between", value1, value2, "managerNumber");
            return (Criteria) this;
        }

        public Criteria andManagerNumberNotBetween(String value1, String value2) {
            addCriterion("manager_number not between", value1, value2, "managerNumber");
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