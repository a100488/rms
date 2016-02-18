// rms依赖验证
if ("undefined" === typeof jQuery) { 
    throw new Error("rms\'s javaScript requires jQuery.");
}
// rms冲突验证
if (rms) {
    throw new Error("rms can not be loaded, it already exists.");
} else {
    var rms = {};
}

// rms初始化
(function(namespace) {
    "use strict";

    // 函数：获取jQuery版本号
    function getJQueryVersion() {
        return $.fn.jquery;
    }

    // 函数：判断浏览器是否为MSIE
    // 说明：1. 不使用$.browser.msie进行判断，因为从jQuery 1.9之后，jQuery不再支持该属性，改为使用$.support
    //          2. 不使用navigator.userAgent进行判断，因为从IE11起，IE的userAgent不再包含"MSIE"文字
    function isMSIE() {
        if (!!window.ActiveXObject || "ActiveXObject" in window) {
            return true;
        } else {
            return false; 
        }
    }

    // 函数：序列化对象转JSON（不支持创建子类对象）
    function serializeArray2obj(serializedParams) {

        var obj = {};
            $.each(serializedParams, function() {
                if ((this.value || "") == "") {
                    return; // 避免服务器端单项目验证（Pattern）无法验证通过
                }
                if (obj[this.name] !== undefined) {
                    if (!obj[this.name].push) {
                        obj[this.name] = [obj[this.name]];
                    }
                    obj[this.name].push(this.value);
                } else {
                    obj[this.name] = this.value;
                }
            });
            return obj;
    };

    // 函数：页面跳转
    function getView(url) {
        location.href = url;
    };

    // 函数：打开新页面
    function newView(url) {
//        window.open(url);
        location.href = url;
    }

    // 函数：关闭页面
    function closeView(url) {
//        window.opener = null;
//        window.open("", "_self");
//        window.close();
        location.href = url;
    }

    // 函数：获取QueryString
    function getQueryString(queryString, key) {

        if (!queryString || queryString == "") {
            queryString = new String(window.location.search);
        }
        if (queryString.indexOf("?") == 0) {
            queryString = queryString.slice(1); //remove "?"
        }

        var pairs = queryString.split("&");
        var result = {};
        pairs.forEach(function(pair) {
            pair = pair.split("=");
            result[pair[0]] = decodeURIComponent(pair[1] || "");
        });

        if (key) {
            return result[key];
        } else {
            return result;
        }
    }

    // 函数：获取ContextPath
    function getContextPath() {
        var pathName = document.location.pathname;
        var index = pathName.substr(1).indexOf("/");
        var result = pathName.substr(0, index+1);
        return result;
    }

    // 函数：取得消息
    function getMessage(key, defaultVal) {
        var empty = "";
        if (defaultVal == null) {
            defaultVal = empty;
        }
        if (namespace.locale == null || key == null || key == empty) {
            return defaultVal;
        }
        return namespace.locale[key] || defaultVal;
    }

    // 函数：格式化字符串
    function formatString(source, params) {
        if (arguments.length == 1 || params == null) {
            return source;
        }
        if (arguments.length > 2 && params.constructor != Array) {
            params = $.makeArray(arguments).slice(1);
        }
        if (params.constructor != Array) {
            params = [params];
        }
        $.each(params, function (i, n) {
            source = source.replace(new RegExp("\\{" + i + "\\}", "g"), n);
        });
        return source;
    }

    // 函数
    function localStorageSupport() {
        return (('localStorage' in window) && window['localStorage'] !== null)
    }

    // 函数
    function saveValueInLocal(key, value) {

        // 优先使用HTML5的localStorage
        if (localStorageSupport()) {
            localStorage.setItem(key, JSON.stringify(value));
        } else if (navigator.cookieEnabled && $.cookie != null) {
            $.cookie(key, JSON.stringify(value));
        } else {
            return;
        }
    }

    // 函数：
    function getValueInLocal(key) {

        // 优先使用HTML5的localStorage
        if (localStorageSupport()) {
            return JSON.parse(localStorage.getItem(key));
        } else if (navigator.cookieEnabled && $.cookie != null) {
            return JSON.parse($.cookie(key));
        } else {
            return null;
        }
    }

    // 将函数添加至dyaspring对象
    namespace.getJQueryVersion = getJQueryVersion;
    namespace.getView = getView;
    namespace.getQueryString = getQueryString;
    namespace.getContextPath = getContextPath;
    namespace.getMessage = getMessage;

    namespace.newView = newView;
    namespace.closeView = closeView;

    namespace.isMSIE = isMSIE;
    namespace.serializeArray2obj = serializeArray2obj;
    namespace.formatString = formatString;
    
    namespace.localStorageSupport = localStorageSupport;
    namespace.saveValueInLocal = saveValueInLocal;
    namespace.getValueInLocal = getValueInLocal;

})(rms);

// jQuery扩展
$.fn.form2object = function() {
    var serializedParams;
    if (this.is("form")) {
        serializedParams = this.serializeArray();
    } else {
        serializedParams = this.find(":input").serializeArray();
    }
    return rms.serializeArray2obj(serializedParams);
}
$.fn.form2json = function() {
    var obj = this.form2object();
    return JSON.stringify(obj);
};
$.fn.content = function(value) {
    return value === undefined ? this.text() : this.text(value === null ? "" : value);
}
$.fn.forbid = function(type, forbidden) {
    if (this.length < 1) {
        return;
    }
    var argLength = arguments.length;
    var setting = {
            type: "disabled",
            forbidden: true
    };
    if (argLength == 2) {
        if (type === "readonly") {
            setting.type = "readonly";
        }
        if (forbidden === false) {
            setting.forbidden = false;
        }
    } else if (argLength == 1) {
        if (type === "readonly") {
            setting.type = "readonly";
        } else if (type === false) {
            setting.forbidden = false;
        }
    }
    var readonly = function(boolean) {
        this.each(function() {
            var element = $(this);
            if (boolean) {
                if (element.is("checkbox") || element.is("radio")) {
                    if (!element.is(":checked")) {
                        element.prop("disabled", true);
                    }
                } else {
                    element.prop("readonly", true);
                    if (element.is("select")) {
                        element.addClass("readonly");
                        element.find("option").not(":selected").prop("disabled", true).hide();
                    } 
                }
            } else {
                if (element.is("checkbox") || element.is("radio")) {
                    element.prop("disabled", false);
                } else {
                    element.prop("readonly", false);
                    if (element.is("select")) {
                        element.removeClass("readonly");
                        element.find("option").prop("disabled", false).show();
                    }
                }
            }
        });
    };
    var disable = function(boolean) {
        this.each(function() {
            var element = $(this);
            if (element.is("a")) {
                element.attr("disabled", boolean);
            } else {
                element.prop("disabled", boolean);
            }
        });
    }
    if (setting.type === "readonly") {
        readonly.call(this, setting.forbidden);
    } else {
        disable.call(this, setting.forbidden);
    }
    return this;
}
$.fn.clearForm = function() {
    this.find("input").not(":radio").not(":checkbox").val("");
    this.find(":checked").prop("checked", false);
    this.find("textarea, select").val("");
    return this;
}