package com.news.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Integer value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Integer value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Integer value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Integer value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Integer value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Integer> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Integer> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Integer value1, Integer value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
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

        public Criteria andArticleNumberIsNull() {
            addCriterion("article_number is null");
            return (Criteria) this;
        }

        public Criteria andArticleNumberIsNotNull() {
            addCriterion("article_number is not null");
            return (Criteria) this;
        }

        public Criteria andArticleNumberEqualTo(String value) {
            addCriterion("article_number =", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberNotEqualTo(String value) {
            addCriterion("article_number <>", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberGreaterThan(String value) {
            addCriterion("article_number >", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberGreaterThanOrEqualTo(String value) {
            addCriterion("article_number >=", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberLessThan(String value) {
            addCriterion("article_number <", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberLessThanOrEqualTo(String value) {
            addCriterion("article_number <=", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberLike(String value) {
            addCriterion("article_number like", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberNotLike(String value) {
            addCriterion("article_number not like", value, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberIn(List<String> values) {
            addCriterion("article_number in", values, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberNotIn(List<String> values) {
            addCriterion("article_number not in", values, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberBetween(String value1, String value2) {
            addCriterion("article_number between", value1, value2, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleNumberNotBetween(String value1, String value2) {
            addCriterion("article_number not between", value1, value2, "articleNumber");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNull() {
            addCriterion("article_title is null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNotNull() {
            addCriterion("article_title is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleEqualTo(String value) {
            addCriterion("article_title =", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotEqualTo(String value) {
            addCriterion("article_title <>", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThan(String value) {
            addCriterion("article_title >", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("article_title >=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThan(String value) {
            addCriterion("article_title <", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThanOrEqualTo(String value) {
            addCriterion("article_title <=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLike(String value) {
            addCriterion("article_title like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotLike(String value) {
            addCriterion("article_title not like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIn(List<String> values) {
            addCriterion("article_title in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotIn(List<String> values) {
            addCriterion("article_title not in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleBetween(String value1, String value2) {
            addCriterion("article_title between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotBetween(String value1, String value2) {
            addCriterion("article_title not between", value1, value2, "articleTitle");
            return (Criteria) this;
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

        public Criteria andArticleTimeIsNull() {
            addCriterion("article_time is null");
            return (Criteria) this;
        }

        public Criteria andArticleTimeIsNotNull() {
            addCriterion("article_time is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTimeEqualTo(Date value) {
            addCriterion("article_time =", value, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeNotEqualTo(Date value) {
            addCriterion("article_time <>", value, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeGreaterThan(Date value) {
            addCriterion("article_time >", value, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("article_time >=", value, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeLessThan(Date value) {
            addCriterion("article_time <", value, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeLessThanOrEqualTo(Date value) {
            addCriterion("article_time <=", value, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeIn(List<Date> values) {
            addCriterion("article_time in", values, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeNotIn(List<Date> values) {
            addCriterion("article_time not in", values, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeBetween(Date value1, Date value2) {
            addCriterion("article_time between", value1, value2, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeNotBetween(Date value1, Date value2) {
            addCriterion("article_time not between", value1, value2, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleStateIsNull() {
            addCriterion("article_state is null");
            return (Criteria) this;
        }

        public Criteria andArticleStateIsNotNull() {
            addCriterion("article_state is not null");
            return (Criteria) this;
        }

        public Criteria andArticleStateEqualTo(String value) {
            addCriterion("article_state =", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateNotEqualTo(String value) {
            addCriterion("article_state <>", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateGreaterThan(String value) {
            addCriterion("article_state >", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateGreaterThanOrEqualTo(String value) {
            addCriterion("article_state >=", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateLessThan(String value) {
            addCriterion("article_state <", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateLessThanOrEqualTo(String value) {
            addCriterion("article_state <=", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateLike(String value) {
            addCriterion("article_state like", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateNotLike(String value) {
            addCriterion("article_state not like", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateIn(List<String> values) {
            addCriterion("article_state in", values, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateNotIn(List<String> values) {
            addCriterion("article_state not in", values, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateBetween(String value1, String value2) {
            addCriterion("article_state between", value1, value2, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateNotBetween(String value1, String value2) {
            addCriterion("article_state not between", value1, value2, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleClicksIsNull() {
            addCriterion("article_clicks is null");
            return (Criteria) this;
        }

        public Criteria andArticleClicksIsNotNull() {
            addCriterion("article_clicks is not null");
            return (Criteria) this;
        }

        public Criteria andArticleClicksEqualTo(Integer value) {
            addCriterion("article_clicks =", value, "articleClicks");
            return (Criteria) this;
        }

        public Criteria andArticleClicksNotEqualTo(Integer value) {
            addCriterion("article_clicks <>", value, "articleClicks");
            return (Criteria) this;
        }

        public Criteria andArticleClicksGreaterThan(Integer value) {
            addCriterion("article_clicks >", value, "articleClicks");
            return (Criteria) this;
        }

        public Criteria andArticleClicksGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_clicks >=", value, "articleClicks");
            return (Criteria) this;
        }

        public Criteria andArticleClicksLessThan(Integer value) {
            addCriterion("article_clicks <", value, "articleClicks");
            return (Criteria) this;
        }

        public Criteria andArticleClicksLessThanOrEqualTo(Integer value) {
            addCriterion("article_clicks <=", value, "articleClicks");
            return (Criteria) this;
        }

        public Criteria andArticleClicksIn(List<Integer> values) {
            addCriterion("article_clicks in", values, "articleClicks");
            return (Criteria) this;
        }

        public Criteria andArticleClicksNotIn(List<Integer> values) {
            addCriterion("article_clicks not in", values, "articleClicks");
            return (Criteria) this;
        }

        public Criteria andArticleClicksBetween(Integer value1, Integer value2) {
            addCriterion("article_clicks between", value1, value2, "articleClicks");
            return (Criteria) this;
        }

        public Criteria andArticleClicksNotBetween(Integer value1, Integer value2) {
            addCriterion("article_clicks not between", value1, value2, "articleClicks");
            return (Criteria) this;
        }

        public Criteria andArticleLikeIsNull() {
            addCriterion("article_like is null");
            return (Criteria) this;
        }

        public Criteria andArticleLikeIsNotNull() {
            addCriterion("article_like is not null");
            return (Criteria) this;
        }

        public Criteria andArticleLikeEqualTo(Integer value) {
            addCriterion("article_like =", value, "articleLike");
            return (Criteria) this;
        }

        public Criteria andArticleLikeNotEqualTo(Integer value) {
            addCriterion("article_like <>", value, "articleLike");
            return (Criteria) this;
        }

        public Criteria andArticleLikeGreaterThan(Integer value) {
            addCriterion("article_like >", value, "articleLike");
            return (Criteria) this;
        }

        public Criteria andArticleLikeGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_like >=", value, "articleLike");
            return (Criteria) this;
        }

        public Criteria andArticleLikeLessThan(Integer value) {
            addCriterion("article_like <", value, "articleLike");
            return (Criteria) this;
        }

        public Criteria andArticleLikeLessThanOrEqualTo(Integer value) {
            addCriterion("article_like <=", value, "articleLike");
            return (Criteria) this;
        }

        public Criteria andArticleLikeIn(List<Integer> values) {
            addCriterion("article_like in", values, "articleLike");
            return (Criteria) this;
        }

        public Criteria andArticleLikeNotIn(List<Integer> values) {
            addCriterion("article_like not in", values, "articleLike");
            return (Criteria) this;
        }

        public Criteria andArticleLikeBetween(Integer value1, Integer value2) {
            addCriterion("article_like between", value1, value2, "articleLike");
            return (Criteria) this;
        }

        public Criteria andArticleLikeNotBetween(Integer value1, Integer value2) {
            addCriterion("article_like not between", value1, value2, "articleLike");
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