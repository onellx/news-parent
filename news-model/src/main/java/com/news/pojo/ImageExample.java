package com.news.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImageExample() {
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

        public Criteria andImageIdIsNull() {
            addCriterion("image_id is null");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNotNull() {
            addCriterion("image_id is not null");
            return (Criteria) this;
        }

        public Criteria andImageIdEqualTo(Integer value) {
            addCriterion("image_id =", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotEqualTo(Integer value) {
            addCriterion("image_id <>", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThan(Integer value) {
            addCriterion("image_id >", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("image_id >=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThan(Integer value) {
            addCriterion("image_id <", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThanOrEqualTo(Integer value) {
            addCriterion("image_id <=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdIn(List<Integer> values) {
            addCriterion("image_id in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotIn(List<Integer> values) {
            addCriterion("image_id not in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdBetween(Integer value1, Integer value2) {
            addCriterion("image_id between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("image_id not between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageTitleIsNull() {
            addCriterion("image_title is null");
            return (Criteria) this;
        }

        public Criteria andImageTitleIsNotNull() {
            addCriterion("image_title is not null");
            return (Criteria) this;
        }

        public Criteria andImageTitleEqualTo(String value) {
            addCriterion("image_title =", value, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleNotEqualTo(String value) {
            addCriterion("image_title <>", value, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleGreaterThan(String value) {
            addCriterion("image_title >", value, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleGreaterThanOrEqualTo(String value) {
            addCriterion("image_title >=", value, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleLessThan(String value) {
            addCriterion("image_title <", value, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleLessThanOrEqualTo(String value) {
            addCriterion("image_title <=", value, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleLike(String value) {
            addCriterion("image_title like", value, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleNotLike(String value) {
            addCriterion("image_title not like", value, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleIn(List<String> values) {
            addCriterion("image_title in", values, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleNotIn(List<String> values) {
            addCriterion("image_title not in", values, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleBetween(String value1, String value2) {
            addCriterion("image_title between", value1, value2, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleNotBetween(String value1, String value2) {
            addCriterion("image_title not between", value1, value2, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImagePathIsNull() {
            addCriterion("image_path is null");
            return (Criteria) this;
        }

        public Criteria andImagePathIsNotNull() {
            addCriterion("image_path is not null");
            return (Criteria) this;
        }

        public Criteria andImagePathEqualTo(String value) {
            addCriterion("image_path =", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotEqualTo(String value) {
            addCriterion("image_path <>", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathGreaterThan(String value) {
            addCriterion("image_path >", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathGreaterThanOrEqualTo(String value) {
            addCriterion("image_path >=", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLessThan(String value) {
            addCriterion("image_path <", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLessThanOrEqualTo(String value) {
            addCriterion("image_path <=", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLike(String value) {
            addCriterion("image_path like", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotLike(String value) {
            addCriterion("image_path not like", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathIn(List<String> values) {
            addCriterion("image_path in", values, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotIn(List<String> values) {
            addCriterion("image_path not in", values, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathBetween(String value1, String value2) {
            addCriterion("image_path between", value1, value2, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotBetween(String value1, String value2) {
            addCriterion("image_path not between", value1, value2, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImageDateIsNull() {
            addCriterion("image_date is null");
            return (Criteria) this;
        }

        public Criteria andImageDateIsNotNull() {
            addCriterion("image_date is not null");
            return (Criteria) this;
        }

        public Criteria andImageDateEqualTo(Date value) {
            addCriterion("image_date =", value, "imageDate");
            return (Criteria) this;
        }

        public Criteria andImageDateNotEqualTo(Date value) {
            addCriterion("image_date <>", value, "imageDate");
            return (Criteria) this;
        }

        public Criteria andImageDateGreaterThan(Date value) {
            addCriterion("image_date >", value, "imageDate");
            return (Criteria) this;
        }

        public Criteria andImageDateGreaterThanOrEqualTo(Date value) {
            addCriterion("image_date >=", value, "imageDate");
            return (Criteria) this;
        }

        public Criteria andImageDateLessThan(Date value) {
            addCriterion("image_date <", value, "imageDate");
            return (Criteria) this;
        }

        public Criteria andImageDateLessThanOrEqualTo(Date value) {
            addCriterion("image_date <=", value, "imageDate");
            return (Criteria) this;
        }

        public Criteria andImageDateIn(List<Date> values) {
            addCriterion("image_date in", values, "imageDate");
            return (Criteria) this;
        }

        public Criteria andImageDateNotIn(List<Date> values) {
            addCriterion("image_date not in", values, "imageDate");
            return (Criteria) this;
        }

        public Criteria andImageDateBetween(Date value1, Date value2) {
            addCriterion("image_date between", value1, value2, "imageDate");
            return (Criteria) this;
        }

        public Criteria andImageDateNotBetween(Date value1, Date value2) {
            addCriterion("image_date not between", value1, value2, "imageDate");
            return (Criteria) this;
        }

        public Criteria andImageStateIsNull() {
            addCriterion("image_state is null");
            return (Criteria) this;
        }

        public Criteria andImageStateIsNotNull() {
            addCriterion("image_state is not null");
            return (Criteria) this;
        }

        public Criteria andImageStateEqualTo(String value) {
            addCriterion("image_state =", value, "imageState");
            return (Criteria) this;
        }

        public Criteria andImageStateNotEqualTo(String value) {
            addCriterion("image_state <>", value, "imageState");
            return (Criteria) this;
        }

        public Criteria andImageStateGreaterThan(String value) {
            addCriterion("image_state >", value, "imageState");
            return (Criteria) this;
        }

        public Criteria andImageStateGreaterThanOrEqualTo(String value) {
            addCriterion("image_state >=", value, "imageState");
            return (Criteria) this;
        }

        public Criteria andImageStateLessThan(String value) {
            addCriterion("image_state <", value, "imageState");
            return (Criteria) this;
        }

        public Criteria andImageStateLessThanOrEqualTo(String value) {
            addCriterion("image_state <=", value, "imageState");
            return (Criteria) this;
        }

        public Criteria andImageStateLike(String value) {
            addCriterion("image_state like", value, "imageState");
            return (Criteria) this;
        }

        public Criteria andImageStateNotLike(String value) {
            addCriterion("image_state not like", value, "imageState");
            return (Criteria) this;
        }

        public Criteria andImageStateIn(List<String> values) {
            addCriterion("image_state in", values, "imageState");
            return (Criteria) this;
        }

        public Criteria andImageStateNotIn(List<String> values) {
            addCriterion("image_state not in", values, "imageState");
            return (Criteria) this;
        }

        public Criteria andImageStateBetween(String value1, String value2) {
            addCriterion("image_state between", value1, value2, "imageState");
            return (Criteria) this;
        }

        public Criteria andImageStateNotBetween(String value1, String value2) {
            addCriterion("image_state not between", value1, value2, "imageState");
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