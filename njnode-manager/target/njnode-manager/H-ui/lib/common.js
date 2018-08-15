/**
 * Handlebars 构建模板内容
 * @param data
 * @returns
 */
String.prototype.compile = function (data) {
    return data ? (Handlebars.compile(this.toString()))(data) : "";
}
/**
 * 时间格式化
 * @param format  格式化样式
 * @returns
 */
Date.prototype.format = function (format) {
    /* 
     * eg:format="yyyy-MM-dd hh:mm:ss"; 
     */
    var o = {
        "M+": this.getMonth() + 1, // month
        "d+": this.getDate(), // day
        "h+": this.getHours(), // hour
        "m+": this.getMinutes(), // minute
        "s+": this.getSeconds(), // second
        "q+": Math.floor((this.getMonth() + 3) / 3), // quarter
        "S": this.getMilliseconds()
        // millisecond  
    };

    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }

    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
};

/**
 * 时间处理对象
 * @constructor
 */
function TimeHandler() {
    /**
     * 获取当前时间增加或减少n天后的日期
     * @param addDays  增加或减少的天数
     * @returns 20180714
     */
    this.getTimeStr = function (addDays) {
        var dd = new Date();
        dd.setDate(dd.getDate() + addDays);//获取AddDayCount天后的日期
        var y = dd.getFullYear();
        var m = dd.getMonth() + 1 + "";//获取当前月份的日期
        var d = dd.getDate() + "";
        return y + "-" + (m.length > 1 ? m : "0" + m) + "-" + (d.length > 1 ? d : "0" + d);
    },
        /**
         * 获取指定年，指定月的天数
         * @param year, month指定年，指定月
         * @returns 31
         */
        this.getDays = function (year, month) {
            var d = new Date(year, month, 0);
            return d.getDate();
        }
}

/*
 * Map对象，实现Map功能
 * size() 获取Map元素个数
 * isEmpty() 判断Map是否为空
 * clear() 删除Map所有元素
 * put(key, value) 向Map中增加元素（key, value)
 * remove(key) 删除指定key的元素，成功返回true，失败返回false
 * get(key) 获取指定key的元素值value，失败返回null
 * element(index) 获取指定索引的元素（使用element.key，element.value获取key和value），失败返回null
 * containsKey(key) 判断Map中是否含有指定key的元素
 * containsValue(value) 判断Map中是否含有指定value的元素
 * keys() 获取Map中所有key的数组（array）
 * values() 获取Map中所有value的数组（array）
 *
 */
function Map(){
    this.elements = new Array();

    //获取Map元素个数
    this.size = function() {
        return this.elements.length;
    },

        //判断Map是否为空
        this.isEmpty = function() {
            return (this.elements.length < 1);
        },

        //删除Map所有元素
        this.clear = function() {
            this.elements = new Array();
        },

        //向Map中增加元素（key, value)
        this.put = function(_key, _value) {
            if (this.containsKey(_key) == true) {
                if(this.containsValue(_value)){
                    if(this.remove(_key) == true){
                        this.elements.push( {
                            key : _key,
                            value : _value
                        });
                    }
                }else{
                    this.elements.push( {
                        key : _key,
                        value : _value
                    });
                }
            } else {
                this.elements.push( {
                    key : _key,
                    value : _value
                });
            }
        },

        //删除指定key的元素，成功返回true，失败返回false
        this.remove = function(_key) {
            var bln = false;
            try {
                for (i = 0; i < this.elements.length; i++) {
                    if (this.elements[i].key == _key){
                        this.elements.splice(i, 1);
                        return true;
                    }
                }
            }catch(e){
                bln = false;
            }
            return bln;
        },

        //获取指定key的元素值value，失败返回null
        this.get = function(_key) {
            try{
                for (i = 0; i < this.elements.length; i++) {
                    if (this.elements[i].key == _key) {
                        return this.elements[i].value;
                    }
                }
            }catch(e) {
                return null;
            }
        },

        //获取指定索引的元素（使用element.key，element.value获取key和value），失败返回null
        this.element = function(_index) {
            if (_index < 0 || _index >= this.elements.length){
                return null;
            }
            return this.elements[_index];
        },

        //判断Map中是否含有指定key的元素
        this.containsKey = function(_key) {
            var bln = false;
            try {
                for (i = 0; i < this.elements.length; i++) {
                    if (this.elements[i].key == _key){
                        bln = true;
                    }
                }
            }catch(e) {
                bln = false;
            }
            return bln;
        },

        //判断Map中是否含有指定value的元素
        this.containsValue = function(_value) {
            var bln = false;
            try {
                for (i = 0; i < this.elements.length; i++) {
                    if (this.elements[i].value == _value){
                        bln = true;
                    }
                }
            }catch(e) {
                bln = false;
            }
            return bln;
        },

        //获取Map中所有key的数组（array）
        this.keys = function() {
            var arr = new Array();
            for (i = 0; i < this.elements.length; i++) {
                arr.push(this.elements[i].key);
            }
            return arr;
        },

        //获取Map中所有value的数组（array）
        this.values = function() {
            var arr = new Array();
            for (i = 0; i < this.elements.length; i++) {
                arr.push(this.elements[i].value);
            }
            return arr;
        };
}




/**
 * 公共的js文件
 */
var NJ_NODE = {
    timeout: 5000,  //ajax提交的超时时间

    /** 有handlebars模板的ajax请求
     * @param data data={currentPage:1,pageSize:10,totalRos:1,.......}
     * @param url
     * @param taget_id
     * @param temp_id
     */
    loadData: function (data, url, taget_id, temp_id, callBack) {
        if (data.currentPage == 0 || data.currentPage > data.totalPages) {
            return false;
        }
        delete data.totalPages;
        NJ_NODE.ajaxPost(data, "json", url, function (data) {
            if (callBack && typeof(callBack) == "function") {
                callBack(data);
            }
            NJ_NODE.buildData(data.data, taget_id, temp_id);
        });

    },

    /**
     * 没有ajax的handlebars
     * @param data
     * @param taget_id
     * @param temp_id
     */
    buildData: function (data, taget_id, temp_id) {
        try {
            if (!data) return;
            var html = $("#" + temp_id).html().compile(data);
            $("#" + taget_id).html(html);
        } catch (e) {
        }
    },
    ajax: function (data, dataType, url, fun, type) {
        layer.load();
        $.ajax({
            url: url,
            type: type,
            dataType: dataType,
            data: data ? data : {},
            timeout: NJ_NODE.timeout,
            success: function (d, status) {
                layer.closeAll('loading');
                var result = {resultCode: 1, data: d};
                fun(result);
            },
            fail: function (err, status) {
                layer.closeAll('loading');
                var result = {resultCode: 0, data: err};
                fun(result);
            }
        });
    },
    ajaxGet: function (data, dataType, url, fun) {
        NJ_NODE.ajax(data, dataType, url, fun, "GET");
    },
    ajaxPost: function (data, dataType, url, fun) {
        NJ_NODE.ajax(data, dataType, url, fun, "POST");
    },
    /**
     * 不带表单验证的ajax提交
     * @param formId
     * @param fn
     */
    ajaxForm: function (formId, fn) {
        $('#' + formId).ajaxForm(function () {
            var index = parent.layer.getFrameIndex(window.name);
            parent.location.reload(true);
            fn();
            parent.layer.close(index);
        }).submit(function () {
            return false;
        });
    },
    /**
     * 带表单验证的ajax提交
     * @param formId ：form的ID
     * @param rules ： 验证规则
     * @param fn ： 毁掉函数
     */
    formValidateAndAjaxSubmit: function (formId, rules, fn, isClose) {
        $("#" + formId).validate({
            rules: rules ? rules : {},
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function (form) {
                $(form).ajaxSubmit(function () {
                    if (isClose) {
                        fn();
                    } else {
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.location.reload(true);
                        fn();
                        parent.layer.close(index);
                    }


                });
            }
        });
    },
    /**
     *
     * @param targerId  地图放的位置id
     * @param lat  经度
     * @param lng  维度
     * @param fun  回掉函数  两个参数，点击后的精度和维度
     */
    initMap: function (targerId, lat, lng, fun) {
        var citylocation, map, marker = null;//54.9878580124252, 95.98068237304688
        var center = new qq.maps.LatLng(lat, lng);
        var map = new qq.maps.Map(document.getElementById(targerId), {
            center: center,
            zoom: 13
        });
        //获取城市列表接口设置中心点
        var citylocation = new qq.maps.CityService({
            complete: function (result) {
                map.setCenter(result.detail.latLng);
            }
        });
        //调用searchLocalCity();方法    根据用户IP查询城市信息。
        citylocation.searchLocalCity();
        //绑定单击事件添加参数
        qq.maps.event.addListener(map, 'click', function (event) {
            fun(event.latLng.getLat(), event.latLng.getLng());
            //$("#lat").val(event.latLng.getLat(),)
            //$("#lng").val(event.latLng.getLng())
        });
    },
    downloadExcelFile: function (url, fileName, sheetName, totalRows, map, statusMap) {
        var tempForm = document.createElement("form");
        tempForm.id = "excelParam";
        tempForm.method = "post";
        tempForm.action = url;
        var hideInput = document.createElement("input");
        hideInput.type = "hidden";
        hideInput.name = "fileName";
        hideInput.value = fileName;
        tempForm.appendChild(hideInput);
        hideInput = document.createElement("input");
        hideInput.type = "hidden";
        hideInput.name = "sheetName";
        hideInput.value = sheetName;
        tempForm.appendChild(hideInput);
        hideInput = document.createElement("input");
        hideInput.type = "hidden";
        hideInput.name = "totalRows";
        hideInput.value = totalRows;
        tempForm.appendChild(hideInput);
        hideInput = document.createElement("input");
        hideInput.type = "hidden";
        hideInput.name = "map";
        hideInput.value = map;
        tempForm.appendChild(hideInput);
        hideInput = document.createElement("input");
        hideInput.type = "hidden";
        hideInput.name = "statusMap";
        hideInput.value = statusMap;
        tempForm.appendChild(hideInput);

        document.body.appendChild(tempForm);
        tempForm.submit();
        document.body.removeChild(tempForm);
    },
    isJson: function (str) {
        try {
            if (typeof JSON.parse(str) == "object") {
                return true;
            }
        } catch (e) {
            return false;
        }
        return false;
    },
    repeat: function (s, count) {
        return new Array(count + 1).join(s);
    },

    formatJson: function (json) {

        var i = 0,
            len = 0,
            tab = "    ",
            targetJson = "",
            indentLevel = 0,
            inString = false,
            currentChar = null;

        for (i = 0, len = json.length; i < len; i += 1) {
            currentChar = json.charAt(i);

            switch (currentChar) {
                case '{':
                case '[':
                    if (!inString) {
                        targetJson += currentChar + "\n" + NJ_NODE.repeat(tab, indentLevel + 1);
                        indentLevel += 1;
                    } else {
                        targetJson += currentChar;
                    }
                    break;
                case '}':
                case ']':
                    if (!inString) {
                        indentLevel -= 1;
                        targetJson += "\n" + NJ_NODE.repeat(tab, indentLevel) + currentChar;
                    } else {
                        targetJson += currentChar;
                    }
                    break;
                case ',':
                    if (!inString) {
                        targetJson += ",\n" + NJ_NODE.repeat(tab, indentLevel);
                    } else {
                        targetJson += currentChar;
                    }
                    break;
                case ':':
                    if (!inString) {
                        targetJson += ": ";
                    } else {
                        targetJson += currentChar;
                    }
                    break;
                case ' ':
                case "\n":
                case "\t":
                    if (inString) {
                        targetJson += currentChar;
                    }
                    break;
                case '"':
                    if (i > 0 && json.charAt(i - 1) !== '\\') {
                        inString = !inString;
                    }
                    targetJson += currentChar;
                    break;
                default:
                    targetJson += currentChar;
                    break;
            }
        }

        return targetJson;
    }
}
