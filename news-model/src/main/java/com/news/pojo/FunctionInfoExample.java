package com.news.pojo;

import java.util.ArrayList;
import java.util.List;

public class FunctionInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FunctionInfoExample() {
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

        public Criteria andFunctionIdIsNull() {
            addCriterion("function_id is null");
            return (Criteria) this;
        }

        public Criteria andFunctionIdIsNotNull() {
            addCriterion("function_id is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionIdEqualTo(Integer value) {
            addCriterion("function_id =", value, "functionId");
            return (Criteria) this;
        }

        public Criteria andFunctionIdNotEqualTo(Integer value) {
            addCriterion("function_id <>", value, "functionId");
            return (Criteria) this;
        }

        public Criteria andFunctionIdGreaterThan(Integer value) {
            addCriterion("function_id >", value, "functionId");
            return (Criteria) this;
        }

        public Criteria andFunctionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("function_id >=", value, "functionId");
            return (Criteria) this;
        }

        public Criteria andFunctionIdLessThan(Integer value) {
            addCriterion("function_id <", value, "functionId");
            return (Criteria) this;
        }

        public Criteria andFunctionIdLessThanOrEqualTo(Integer value) {
            addCriterion("function_id <=", value, "functionId");
            return (Criteria) this;
        }

        public Criteria andFunctionIdIn(List<Integer> values) {
            addCriterion("function_id in", values, "functionId");
            return (Criteria) this;
        }

        public Criteria andFunctionIdNotIn(List<Integer> values) {
            addCriterion("function_id not in", values, "functionId");
            return (Criteria) this;
        }

        public Criteria andFunctionIdBetween(Integer value1, Integer value2) {
            addCriterion("function_id between", value1, value2, "functionId");
            return (Criteria) this;
        }

        public Criteria andFunctionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("function_id not between", value1, value2, "functionId");
            return (Criteria) this;
        }

        public Criteria andFunctionNameIsNull() {
            addCriterion("function_name is null");
            return (Criteria) this;
        }

        public Criteria andFunctionNameIsNotNull() {
            addCriterion("function_name is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionNameEqualTo(String value) {
            addCriterion("function_name =", value, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameNotEqualTo(String value) {
            addCriterion("function_name <>", value, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameGreaterThan(String value) {
            addCriterion("function_name >", value, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameGreaterThanOrEqualTo(String value) {
            addCriterion("function_name >=", value, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameLessThan(String value) {
            addCriterion("function_name <", value, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameLessThanOrEqualTo(String value) {
            addCriterion("function_name <=", value, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameLike(String value) {
            addCriterion("function_name like", value, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameNotLike(String value) {
            addCriterion("function_name not like", value, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameIn(List<String> values) {
            addCriterion("function_name in", values, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameNotIn(List<String> values) {
            addCriterion("function_name not in", values, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameBetween(String value1, String value2) {
            addCriterion("function_name between", value1, value2, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionNameNotBetween(String value1, String value2) {
            addCriterion("function_name not between", value1, value2, "functionName");
            return (Criteria) this;
        }

        public Criteria andFunctionSiteIsNull() {
            addCriterion("function_site is null");
            return (Criteria) this;
        }

        public Criteria andFunctionSiteIsNotNull() {
            addCriterion("function_site is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionSiteEqualTo(String value) {
            addCriterion("function_site =", value, "functionSite");
            return (Criteria) this;
        }

        public Criteria andFunctionSiteNotEqualTo(String value) {
            addCriterion("function_site <>", value, "functionSite");
            return (Criteria) this;
        }

        public Criteria andFunctionSiteGreaterThan(String value) {
            addCriterion("function_site >", value, "functionSite");
            return (Criteria) this;
        }

        public Criteria andFunctionSiteGreaterThanOrEqualTo(String value) {
            addCriterion("function_site >=", value, "functionSite");
            return (Criteria) this;
        }

        public Criteria andFunctionSiteLessThan(String value) {
            addCriterion("function_site <", value, "functionSite");
            return (Criteria) this;
        }

        public Criteria andFunctionSiteLessThanOrEqualTo(String value) {
            addCriterion("function_site <=", value, "functionSite");
            return (Criteria) this;
        }

        public Criteria andFunctionSiteLike(String value) {
            addCriterion("function_site like", value, "functionSite");
            return (Criteria) this;
        }

        public Criteria andFunctionSiteNotLike(String value) {
            addCriterion("function_site not like", value, "functionSite");
            return (Criteria) this;
        }

        public Criteria andFunctionSiteIn(List<String> values) {
            addCriterion("function_site in", values, "functionSite");
            return (Criteria) this;
        }

        public Criteria andFunctionSiteNotIn(List<String> values) {
            addCriterion("function_site not in", values, "functionSite");
            return (Criteria) this;
        }

        public Criteria andFunctionSiteBetween(String value1, String value2) {
            addCriterion("function_site between", value1, value2, "functionSite");
            return (Criteria) this;
        }

        public Criteria andFunctionSiteNotBetween(String value1, String value2) {
            addCriterion("function_site not between", value1, value2, "functionSite");
            return (Criteria) this;
        }

        public Criteria andFunctionCommentIsNull() {
            addCriterion("function_comment is null");
            return (Criteria) this;
        }

        public Criteria andFunctionCommentIsNotNull() {
            addCriterion("function_comment is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionCommentEqualTo(String value) {
            addCriterion("function_comment =", value, "functionComment");
            return (Criteria) this;
        }

        public Criteria andFunctionCommentNotEqualTo(String value) {
            addCriterion("function_comment <>", value, "functionComment");
            return (Criteria) this;
        }

        public Criteria andFunctionCommentGreaterThan(String value) {
            addCriterion("function_comment >", value, "functionComment");
            return (Criteria) this;
        }

        public Criteria andFunctionCommentGreaterThanOrEqualTo(String value) {
            addCriterion("function_comment >=", value, "functionComment");
            return (Criteria) this;
        }

        public Criteria andFunctionCommentLessThan(String value) {
            addCriterion("function_comment <", value, "functionComment");
            return (Criteria) this;
        }

        public Criteria andFunctionCommentLessThanOrEqualTo(String value) {
            addCriterion("function_comment <=", value, "functionComment");
            return (Criteria) this;
        }

        public Criteria andFunctionCommentLike(String value) {
            addCriterion("function_comment like", value, "functionComment");
            return (Criteria) this;
        }

        public Criteria andFunctionCommentNotLike(String value) {
            addCriterion("function_comment not like", value, "functionComment");
            return (Criteria) this;
        }

        public Criteria andFunctionCommentIn(List<String> values) {
            addCriterion("function_comment in", values, "functionComment");
            return (Criteria) this;
        }

        public Criteria andFunctionCommentNotIn(List<String> values) {
            addCriterion("function_comment not in", values, "functionComment");
            return (Criteria) this;
        }

        public Criteria andFunctionCommentBetween(String value1, String value2) {
            addCriterion("function_comment between", value1, value2, "functionComment");
            return (Criteria) this;
        }

        public Criteria andFunctionCommentNotBetween(String value1, String value2) {
            addCriterion("function_comment not between", value1, value2, "functionComment");
            return (Criteria) this;
        }

        public Criteria andModuleIdIsNull() {
            addCriterion("module_id is null");
            return (Criteria) this;
        }

        public Criteria andModuleIdIsNotNull() {
            addCriterion("module_id is not null");
            return (Criteria) this;
        }

        public Criteria andModuleIdEqualTo(Integer value) {
            addCriterion("module_id =", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotEqualTo(Integer value) {
            addCriterion("module_id <>", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdGreaterThan(Integer value) {
            addCriterion("module_id >", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("module_id >=", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLessThan(Integer value) {
            addCriterion("module_id <", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLessThanOrEqualTo(Integer value) {
            addCriterion("module_id <=", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdIn(List<Integer> values) {
            addCriterion("module_id in", values, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotIn(List<Integer> values) {
            addCriterion("module_id not in", values, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdBetween(Integer value1, Integer value2) {
            addCriterion("module_id between", value1, value2, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("module_id not between", value1, value2, "moduleId");
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