webpackJsonp([26],{196:function(e,t,o){function n(e){o(290)}var r=o(5)(o(245),o(323),n,"data-v-2cf805fb",null);e.exports=r.exports},203:function(e,t,o){"use strict";function n(e){return o.i(v.a)("/apply/create",e,"post")}function r(e){return o.i(v.a)("/apply/drop",e,"post")}function a(e){return o.i(v.a)("/apply/disable",e,"post")}function i(e){return o.i(v.a)("/user/update",e,"post")}function s(e){return o.i(v.a)("/apply/update",e,"post")}function c(e){return o.i(v.a)("/api/submitSetInfo",e,"post")}function l(e){return o.i(v.a)("/static/deviceClass?"+e,e,"get")}function p(e){return o.i(v.a)("/static/deviceType?"+e,e,"get")}function u(e){return o.i(v.a)("/map/provinces",e,"get")}function f(e){return o.i(v.a)("/map/cities?"+e,e,"get")}function d(e){return o.i(v.a)("/map/areas?"+e,e,"get")}function g(e){return o.i(v.a)("/apply/get?"+e,e,"get")}function A(e){return o.i(v.a)("/apply/confirm?"+e,e,"get")}function m(e){return o.i(v.a)("/map/organization?"+e,e,"get")}t.f=n,t.l=r,t.k=a,t.n=i,t.g=s,t.j=c,t.m=l,t.i=p,t.a=u,t.b=f,t.c=d,t.e=g,t.h=A,t.d=m;var v=o(32)},245:function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n=o(13),r=o.n(n),a=o(6),i=o(203),s=o(19),c=o(33);o.n(c);t.default={data:function(){return{choose:"acceptor",role:"acceptor",registInfo:{username:"",province:"",city:"",area:"",acceptCom:"",name:"",verifyId:"",password:"",password2:"",useComName:"",mobilePhone:""},acceptComList:[],province:"",provinceId:"",city:"",provinceList:[],cityList:[],cityId:"",area:"",areaList:[],areaId:"",acceptCom:"",verifyId:"",rules:{useComName:[{required:!0,message:"不能为空",trigger:"blur"}],name:[{required:!0,message:"不能为空",trigger:"blur"}],verifyId:[{required:!0,message:"不能为空",trigger:"blur"}],mobilePhone:[{required:!0,message:"不能为空",trigger:"blur"}],password:[{required:!0,message:"不能为空",trigger:"blur"}],password2:[{required:!0,message:"不能为空",trigger:"blur"}],username:[{required:!0,message:"不能为空",trigger:"blur"}]}}},computed:r()({defaultActive:function(){return this.$route.path.replace("/","")}},o.i(a.a)(["headShow"])),mounted:function(){this.author_key=localStorage.getItem("author_key"),this.initData()},components:{},methods:{chooseRole:function(e){console.log(e),this.role=""==e?"acceptor\0\0\0\0\0\0\0\0":"approver\0\0\0\0\0\0\0\0"},initData:function(){var e=this;i.a().then(function(t){for(var o=0,n=t.length;o<n;o++)e.provinceList.push({value:t[o].code,label:t[o].name});console.log(e.provinceList)}).catch(function(e){console.log(e)})},chosenPro:function(e){var t=this,o="provinceCode="+e;this.provinceId=e,""!==e&&i.b(o).then(function(e){t.cityList=[];for(var o=0,n=e.length;o<n;o++)t.cityList.push({value:e[o].code,label:e[o].name})}).catch(function(e){console.log(e)})},chosenCity:function(e){var t=this,o="cityCode="+e,n="code="+e;this.cityId=e,""!==e&&(i.c(o).then(function(e){t.areaList=[];for(var o=0,n=e.length;o<n;o++)t.areaList.push({value:e[o].code,label:e[o].name})}).catch(function(e){console.log(e)}),s.d(n).then(function(e){for(var o=0,n=e.length;o<n;o++)t.acceptComList.push({value:e[o].id,label:e[o].name})}).catch(function(e){console.log(e)}))},chosenArea:function(e){var t=this;this.areaId=e;var o="addressCode="+e;s.d(o).then(function(e){t.acceptComList=[];for(var o=0,n=e.length;o<n;o++)t.acceptComList.push({value:e[o].id,label:e[o].name})}).catch(function(e){console.log(e)})},chosenAccept:function(e){console.log(e),this.propertyComCode=e.value,this.propertyComName=e.label},regist:function(){var e=this;this.$refs.registInfo.validate(function(t){if(!t)return console.log("error submit!!"),e.$Message.info("尚有信息不符合要求，请检查"),!1;if(e.registInfo.password!==e.registInfo.password2)return void e.$Notice.error({title:"这是通知标题",desc:"两次密码填写不相同"});if(""==e.registInfo.acceptCom)return void e.$Notice.error({title:"这是通知标题",desc:"请选择登记机关"});var o={};o.username=e.registInfo.username,o.password=e.registInfo.password;var n={name:e.registInfo.name,acceptorAgencyId:parseInt(e.propertyComCode),acceptorAgencyName:e.propertyComName,verifyId:e.registInfo.verifyId,mobilePhone:e.registInfo.mobilePhone};o.userData=n,console.log(e.role),"acceptor"==e.role?(o.userData.role=2,s.e(o).then(function(t){200===t.status?(e.$Message.info("注册成功，请登录"),e.$router.push("login")):500===t.status&&e.$Message.info(t.msg)}).catch(function(e){console.log(e)})):(o.userData.role=3,s.f(o).then(function(t){200===t.status?(e.$Message.info("注册成功，请登录"),e.$router.push("login")):500===t.status&&e.$Message.info(t.msg)}).catch(function(e){console.log(e)}))})}}}},257:function(e,t,o){t=e.exports=o(168)(!0),t.push([e.i,".AcceptRegist[data-v-2cf805fb]{width:60%;margin:0 auto;margin-top:50px;padding-bottom:10px;height:80%;border:2px solid #dddee1;border-top-left-radius:0;border-top-right-radius:0;border-bottom-right-radius:3px;border-bottom-left-radius:3px}.head[data-v-2cf805fb]{height:60px;display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-align:center;-ms-flex-align:center;align-items:center;-webkit-box-pack:center;-ms-flex-pack:center;justify-content:center;font-weight:700;font:#464c5b;font-size:30px}.body[data-v-2cf805fb]{width:50%;margin:0 auto;padding:20px}.label[data-v-2cf805fb]{text-align:right;vertical-align:middle;float:left;font-size:16px;line-height:1;padding:10px 12px 10px 0;box-sizing:border-box}","",{version:3,sources:["/Users/zhangyunlong/Downloads/my-project/src/page/regist/acceptRegist.vue"],names:[],mappings:"AACA,+BACE,UAAW,AACX,cAAe,AACf,gBAAiB,AACjB,oBAAqB,AACrB,WAAY,AACZ,yBAA0B,AAC1B,yBAA0B,AAC1B,0BAA2B,AAC3B,+BAAgC,AAChC,6BAA+B,CAChC,AACD,uBACE,YAAa,AACb,oBAAqB,AACrB,oBAAqB,AACrB,aAAc,AACd,yBAA0B,AACtB,sBAAuB,AACnB,mBAAoB,AAC5B,wBAAyB,AACrB,qBAAsB,AAClB,uBAAwB,AAChC,gBAAkB,AAClB,aAAc,AACd,cAAgB,CACjB,AACD,uBACE,UAAW,AACX,cAAe,AACf,YAA6B,CAC9B,AACD,wBACE,iBAAkB,AAClB,sBAAuB,AACvB,WAAY,AACZ,eAAgB,AAChB,cAAe,AACf,yBAA0B,AAC1B,qBAAuB,CACxB",file:"acceptRegist.vue",sourcesContent:["\n.AcceptRegist[data-v-2cf805fb] {\n  width: 60%;\n  margin: 0 auto;\n  margin-top: 50px;\n  padding-bottom: 10px;\n  height: 80%;\n  border: 2px solid #dddee1;\n  border-top-left-radius: 0;\n  border-top-right-radius: 0;\n  border-bottom-right-radius: 3px;\n  border-bottom-left-radius: 3px;\n}\n.head[data-v-2cf805fb] {\n  height: 60px;\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-align: center;\n      -ms-flex-align: center;\n          align-items: center;\n  -webkit-box-pack: center;\n      -ms-flex-pack: center;\n          justify-content: center;\n  font-weight: bold;\n  font: #464c5b;\n  font-size: 30px;\n}\n.body[data-v-2cf805fb] {\n  width: 50%;\n  margin: 0 auto;\n  padding: 20px 20px 20px 20px;\n}\n.label[data-v-2cf805fb] {\n  text-align: right;\n  vertical-align: middle;\n  float: left;\n  font-size: 16px;\n  line-height: 1;\n  padding: 10px 12px 10px 0;\n  box-sizing: border-box;\n}\n"],sourceRoot:""}])},290:function(e,t,o){var n=o(257);"string"==typeof n&&(n=[[e.i,n,""]]),n.locals&&(e.exports=n.locals);o(169)("190dc957",n,!0)},323:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"AcceptRegist"},[o("div",{staticClass:"head"},[e._v("登记机关注册使用账号")]),e._v(" "),o("div",{staticClass:"body"},[o("RadioGroup",{staticStyle:{"margin-left":"100px","margin-bottom":"10px"},on:{"on-change":e.chooseRole},model:{value:e.choose,callback:function(t){e.choose=t},expression:"choose"}},[o("Radio",{attrs:{label:"acceptor"}},[e._v("受理机关")]),e._v(" "),o("Radio",{attrs:{label:"approver"}},[e._v("审批机关")])],1),e._v(" "),o("Form",{ref:"registInfo",attrs:{model:e.registInfo,"label-width":120,rules:e.rules}},[o("Row",[o("FormItem",{attrs:{prop:"username",label:"用户名"}},[o("Poptip",{attrs:{trigger:"focus",placement:"right"}},[o("div",{staticStyle:{"white-space":"normal"},slot:"content"},[o("p",[e._v("登录账号，至少5个字符，要求大小写字母和数字")])]),e._v(" "),o("Input",{attrs:{placeholder:"用户名"},model:{value:e.registInfo.username,callback:function(t){e.registInfo.username=t},expression:"registInfo.username"}})],1)],1)],1),e._v(" "),o("Row",[o("FormItem",{attrs:{prop:"password",label:"密码"}},[o("Poptip",{attrs:{trigger:"focus",placement:"right"}},[o("div",{staticStyle:{"white-space":"normal"},slot:"content"},[o("p",[e._v("登录密码，至少5个字符，要求大小写字母和数字")])]),e._v(" "),o("Input",{attrs:{type:"password",placeholder:"密码"},model:{value:e.registInfo.password,callback:function(t){e.registInfo.password=t},expression:"registInfo.password"}})],1)],1)],1),e._v(" "),o("Row",[o("FormItem",{attrs:{prop:"password2",label:"确认密码"}},[o("Poptip",{attrs:{trigger:"focus",placement:"right"}},[o("div",{staticStyle:{"white-space":"normal"},slot:"content"},[o("p",[e._v("确认两次密码填写相等")])]),e._v(" "),o("Input",{attrs:{type:"password",placeholder:"确认密码"},model:{value:e.registInfo.password2,callback:function(t){e.registInfo.password2=t},expression:"registInfo.password2"}})],1)],1)],1),e._v(" "),o("Row",[o("FormItem",{staticClass:"ivu-form-item-required ivu-form-item-label",staticStyle:{"margin-bottom":"10px"},attrs:{prop:"useComAddr",label:"登记机关名称"}},[o("Col",{staticStyle:{"margin-right":"20px"},attrs:{span:"7"}},[o("Select",{staticStyle:{width:"120%"},attrs:{filterable:""},on:{"on-change":e.chosenPro},model:{value:e.province,callback:function(t){e.province=t},expression:"province"}},e._l(e.provinceList,function(t){return o("Option",{key:t.value,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),e._v(" "),o("Col",{staticStyle:{"margin-right":"20px"},attrs:{span:"7"}},[o("Select",{staticStyle:{width:"120%"},attrs:{filterable:""},on:{"on-change":e.chosenCity},model:{value:e.city,callback:function(t){e.city=t},expression:"city"}},e._l(e.cityList,function(t){return o("Option",{key:t.value,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1),e._v(" "),o("Col",{attrs:{span:"7"}},[o("Select",{staticStyle:{width:"120%"},attrs:{filterable:""},on:{"on-change":e.chosenArea},model:{value:e.area,callback:function(t){e.area=t},expression:"area"}},e._l(e.areaList,function(t){return o("Option",{key:t.value,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1)],1)],1),e._v(" "),o("FormItem",{attrs:{prop:"acceptCom",label:""}},[o("Row",[o("Select",{attrs:{filterable:"","label-in-value":!0},on:{"on-change":e.chosenAccept},model:{value:e.registInfo.acceptCom,callback:function(t){e.registInfo.acceptCom=t},expression:"registInfo.acceptCom"}},e._l(e.acceptComList,function(t){return o("Option",{key:t.value,attrs:{value:t.value}},[e._v(e._s(t.label))])}))],1)],1),e._v(" "),o("Row",[o("FormItem",{attrs:{prop:"name",label:"登记人员"}},[o("Input",{attrs:{placeholder:"填写负责登记工作的人员姓名"},model:{value:e.registInfo.name,callback:function(t){e.registInfo.name=t},expression:"registInfo.name"}})],1)],1),e._v(" "),o("Row",[o("FormItem",{attrs:{prop:"verifyId",label:"身份证号"}},[o("Input",{attrs:{placeholder:"请填入登记人员的公民身份证号码"},model:{value:e.registInfo.verifyId,callback:function(t){e.registInfo.verifyId=t},expression:"registInfo.verifyId"}})],1)],1),e._v(" "),o("FormItem",{attrs:{prop:"mobilePhone",label:"移动电话号码"}},[o("Row",[o("Input",{attrs:{placeholder:"请填入安全管理员的移动电话号码"},model:{value:e.registInfo.mobilePhone,callback:function(t){e.registInfo.mobilePhone=t},expression:"registInfo.mobilePhone"}})],1)],1),e._v(" "),o("Row",[o("Button",{staticStyle:{"font-size":"16px","font-weight":"bold"},attrs:{type:"primary",long:""},on:{click:function(t){e.regist()}}},[e._v("立即注册")])],1)],1)],1)])},staticRenderFns:[]}}});
//# sourceMappingURL=26.4c0121a9c4b4f0701533.js.map