webpackJsonp([24],{198:function(e,t,a){function r(e){a(311)}var o=a(5)(a(247),a(344),r,"data-v-71d4b1dc",null);e.exports=o.exports},203:function(e,t,a){"use strict";function r(e){return a.i(g.a)("/apply/create",e,"post")}function o(e){return a.i(g.a)("/apply/drop",e,"post")}function n(e){return a.i(g.a)("/apply/disable",e,"post")}function i(e){return a.i(g.a)("/user/update",e,"post")}function c(e){return a.i(g.a)("/apply/update",e,"post")}function l(e){return a.i(g.a)("/api/submitSetInfo",e,"post")}function s(e){return a.i(g.a)("/static/deviceClass?"+e,e,"get")}function u(e){return a.i(g.a)("/static/deviceType?"+e,e,"get")}function p(e){return a.i(g.a)("/map/provinces",e,"get")}function m(e){return a.i(g.a)("/map/cities?"+e,e,"get")}function d(e){return a.i(g.a)("/map/areas?"+e,e,"get")}function v(e){return a.i(g.a)("/apply/get?"+e,e,"get")}function f(e){return a.i(g.a)("/apply/confirm?"+e,e,"get")}function h(e){return a.i(g.a)("/map/organization?"+e,e,"get")}t.f=r,t.l=o,t.k=n,t.n=i,t.g=c,t.j=l,t.m=s,t.i=u,t.a=p,t.b=m,t.c=d,t.e=v,t.h=f,t.d=h;var g=a(32)},247:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=(a(6),a(203)),o=a(19);t.default={data:function(){var e=this;return{ruleForm:{username:"",acceptorAgencyName:"",password:"",confirmPassword:"",role:"",acceptCom:"",province:"",city:"",area:""},province:"",provinceId:"",city:"",provinceList:[],cityList:[],cityId:"",area:"",areaList:[],areaId:"",acceptCom:"",acceptComList:[],roleList:[{value:"1",label:"使用单位"},{value:"2",label:"受理机关"},{value:"3",label:"审批机关"},{value:"4",label:"监管机关"}],formRules:{username:[{required:!0,message:"账号不能为空",trigger:"blur"}],password:[{required:!0,message:"密码不能为空",trigger:"blur"},{type:"string",min:6,message:"密码不能少于6位数",trigger:"blur"}],confirmPassword:[{required:!0,message:"确认密码不能为空",trigger:"blur"},{validator:function(t,a,r){""===a?r(new Error("请再次输入密码")):a!==e.ruleForm.password?r(new Error("两次输入密码不一致!")):r()},trigger:"blur"}]}}},mounted:function(){this.initData()},methods:{submit:function(){this.$router.go(-1)},initData:function(){var e=this;r.a().then(function(t){for(var a=0,r=t.length;a<r;a++)e.provinceList.push({value:t[a].code,label:t[a].name});console.log(e.provinceList)}).catch(function(e){console.log(e)})},chosenPro:function(e){var t=this,a="provinceCode="+e;this.provinceId=e,""!==e&&r.b(a).then(function(e){t.cityList=[];for(var a=0,r=e.length;a<r;a++)t.cityList.push({value:e[a].code,label:e[a].name})}).catch(function(e){console.log(e)})},chosenCity:function(e){var t=this,a="cityCode="+e,n="code="+e;this.cityId=e,""!==e&&(r.c(a).then(function(e){t.areaList=[];for(var a=0,r=e.length;a<r;a++)t.areaList.push({value:e[a].code,label:e[a].name})}).catch(function(e){console.log(e)}),o.d(n).then(function(e){for(var a=0,r=e.length;a<r;a++)t.acceptComList.push({value:e[a].districtCode,label:e[a].name})}).catch(function(e){console.log(e)}))},chosenArea:function(e){var t=this;this.areaId=e;var a="addressCode="+e;o.d(a).then(function(e){t.acceptComList=[];for(var a=0,r=e.length;a<r;a++)t.acceptComList.push({value:e[a].districtCode,label:e[a].name})}).catch(function(e){console.log(e)})},chosenAccept:function(e){this.propertyComCode=e.value,this.propertyComName=this.acceptCom.label}}}},278:function(e,t,a){t=e.exports=a(168)(!0),t.push([e.i,".container[data-v-71d4b1dc]{padding:15px}.head[data-v-71d4b1dc]{margin-bottom:10px}","",{version:3,sources:["/Users/zhangyunlong/Downloads/my-project/src/page/superAdmin/newUser.vue"],names:[],mappings:"AACA,4BACE,YAAc,CACf,AACD,uBACE,kBAAoB,CACrB",file:"newUser.vue",sourcesContent:["\n.container[data-v-71d4b1dc] {\n  padding: 15px;\n}\n.head[data-v-71d4b1dc] {\n  margin-bottom: 10px;\n}\n"],sourceRoot:""}])},311:function(e,t,a){var r=a(278);"string"==typeof r&&(r=[[e.i,r,""]]),r.locals&&(e.exports=r.locals);a(169)("0664fdf0",r,!0)},344:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"container"},[a("h2",{staticClass:"head"},[e._v("添加登记机关用户")]),e._v(" "),a("Form",{ref:"ruleForm",attrs:{rules:e.formRules,"label-position":"right","label-width":120,model:e.ruleForm}},[a("FormItem",{attrs:{label:"用户名",prop:"username"}},[a("Input",{staticStyle:{width:"200px"},attrs:{placeholder:"请输入"},model:{value:e.ruleForm.username,callback:function(t){e.ruleForm.username=t},expression:"ruleForm.username"}})],1),e._v(" "),a("FormItem",{attrs:{label:"密码",prop:"password"}},[a("Input",{staticStyle:{width:"200px"},attrs:{placeholder:"请输入"},model:{value:e.ruleForm.password,callback:function(t){e.ruleForm.password=t},expression:"ruleForm.password"}})],1),e._v(" "),a("FormItem",{attrs:{label:"确认密码",prop:"confirmPassword"}},[a("Input",{staticStyle:{width:"200px"},attrs:{placeholder:"请输入"},model:{value:e.ruleForm.confirmPassword,callback:function(t){e.ruleForm.confirmPassword=t},expression:"ruleForm.confirmPassword"}})],1),e._v(" "),a("FormItem",{attrs:{prop:"useComName",label:"登记机关名称"}},[a("Row",[a("Col",{staticStyle:{"padding-right":"10px"},attrs:{span:"6"}},[a("Select",{attrs:{filterable:""},on:{"on-change":e.chosenPro},model:{value:e.province,callback:function(t){e.province=t},expression:"province"}},e._l(e.provinceList,function(t){return a("Option",{key:t.value,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),e._v(" "),a("Col",{staticStyle:{"padding-right":"10px"},attrs:{span:"6"}},[a("Select",{staticStyle:{"margin-bottom":"25px"},attrs:{filterable:""},on:{"on-change":e.chosenCity},model:{value:e.city,callback:function(t){e.city=t},expression:"city"}},e._l(e.cityList,function(t){return a("Option",{key:t.value,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),e._v(" "),a("Col",{attrs:{span:"6"}},[a("Select",{staticStyle:{"margin-bottom":"25px"},attrs:{filterable:""},on:{"on-change":e.chosenArea},model:{value:e.area,callback:function(t){e.area=t},expression:"area"}},e._l(e.areaList,function(t){return a("Option",{key:t.value,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1)],1),e._v(" "),a("Row",[a("Select",{attrs:{filterable:"","label-in-value":!0},on:{"on-change":e.chosenAccept},model:{value:e.acceptCom,callback:function(t){e.acceptCom=t},expression:"acceptCom"}},e._l(e.acceptComList,function(t){return a("Option",{key:t.value,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1)],1),e._v(" "),a("FormItem",{attrs:{label:"权限"}},[a("Select",{staticStyle:{width:"26%"},model:{value:e.ruleForm.role,callback:function(t){e.ruleForm.role=t},expression:"ruleForm.role"}},e._l(e.roleList,function(t){return a("Option",{key:t.value,attrs:{value:t.value}},[e._v(e._s(t.label)+"\n        ")])}))],1),e._v(" "),a("FormItem",{attrs:{label:""}},[a("Button",{attrs:{type:"primary"},on:{click:e.submit}},[e._v("添加")])],1)],1)],1)},staticRenderFns:[]}}});
//# sourceMappingURL=24.3a2b0d6e07795913f36f.js.map