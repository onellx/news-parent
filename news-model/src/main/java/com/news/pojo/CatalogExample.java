package com.news.pojo;

import java.util.ArrayList;
import java.util.List;

public class CatalogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CatalogExample() {
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

        public Criteria andCatalogIdIsNull() {
            addCriterion("catalog_id is null");
            return (Criteria) this;
        }

        public Criteria andCatalogIdIsNotNull() {
            addCriterion("catalog_id is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogIdEqualTo(Integer value) {
            addCriterion("catalog_id =", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdNotEqualTo(Integer value) {
            addCriterion("catalog_id <>", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdGreaterThan(Integer value) {
            addCriterion("catalog_id >", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("catalog_id >=", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdLessThan(Integer value) {
            addCriterion("catalog_id <", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdLessThanOrEqualTo(Integer value) {
            addCriterion("catalog_id <=", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdIn(List<Integer> values) {
            addCriterion("catalog_id in", values, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdNotIn(List<Integer> values) {
            addCriterion("catalog_id not in", values, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdBetween(Integer value1, Integer value2) {
            addCriterion("catalog_id between", value1, value2, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("catalog_id not between", value1, value2, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogNameIsNull() {
            addCriterion("catalog_name is null");
            return (Criteria) this;
        }

        public Criteria andCatalogNameIsNotNull() {
            addCriterion("catalog_name is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogNameEqualTo(String value) {
            addCriterion("catalog_name =", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotEqualTo(String value) {
            addCriterion("catalog_name <>", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameGreaterThan(String value) {
            addCriterion("catalog_name >", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameGreaterThanOrEqualTo(String value) {
            addCriterion("catalog_name >=", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameLessThan(String value) {
            addCriterion("catalog_name <", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameLessThanOrEqualTo(String value) {
            addCriterion("catalog_name <=", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameLike(String value) {
            addCriterion("catalog_name like", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotLike(String value) {
            addCriterion("catalog_name not like", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameIn(List<String> values) {
            addCriterion("catalog_name in", values, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotIn(List<String> values) {
            addCriterion("catalog_name not in", values, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameBetween(String value1, String value2) {
            addCriterion("catalog_name between", value1, value2, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotBetween(String value1, String value2) {
            addCriterion("catalog_name not between", value1, value2, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogStateIsNull() {
            addCriterion("catalog_state is null");
            return (Criteria) this;
        }

        public Criteria andCatalogStateIsNotNull() {
            addCriterion("catalog_state is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogStateEqualTo(String value) {
            addCriterion("catalog_state =", value, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateNotEqualTo(String value) {
            addCriterion("catalog_state <>", value, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateGreaterThan(String value) {
            addCriterion("catalog_state >", value, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateGreaterThanOrEqualTo(String value) {
            addCriterion("catalog_state >=", value, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateLessThan(String value) {
            addCriterion("catalog_state <", value, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateLessThanOrEqualTo(String value) {
            addCriterion("catalog_state <=", value, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateLike(String value) {
            addCriterion("catalog_state like", value, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateNotLike(String value) {
            addCriterion("catalog_state not like", value, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateIn(List<String> values) {
            addCriterion("catalog_state in", values, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateNotIn(List<String> values) {
            addCriterion("catalog_state not in", values, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateBetween(String value1, String value2) {
            addCriterion("catalog_state between", value1, value2, "catalogState");
            return (Criteria) this;
        }

        public Criteria andCatalogStateNotBetween(String value1, String value2) {
            addCriterion("catalog_state not between", value1, value2, "catalogState");
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