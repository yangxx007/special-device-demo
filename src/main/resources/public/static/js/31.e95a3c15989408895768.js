webpackJsonp([31],{199:function(e,t,r){function o(e){r(380)}var a=r(4)(r(305),r(421),o,"data-v-6232adf2",null);e.exports=a.exports},215:function(e,t,r){"use strict";function o(e){return r.i(m.a)("/apply/create",e,"post")}function a(e){return r.i(m.a)("/apply/update",e,"post")}function i(e){return r.i(m.a)("/api/submitSetInfo",e,"post")}function n(e){return r.i(m.a)("/static/deviceClass?"+e,e,"get")}function s(e){return r.i(m.a)("/static/deviceType?"+e,e,"get")}function l(e){return r.i(m.a)("/map/provinces",e,"get")}function p(e){return r.i(m.a)("/map/cities?"+e,e,"get")}function d(e){return r.i(m.a)("/map/areas?"+e,e,"get")}function c(e){return r.i(m.a)("/apply/get?"+e,e,"get")}function u(e){return r.i(m.a)("/apply/confirm?"+e,e,"get")}t.b=o,t.c=a,t.f=i,t.g=n,t.e=s,t.h=l,t.i=p,t.j=d,t.a=c,t.d=u;var m=r(19)},305:function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o=r(65),a=r.n(o),i=r(13),n=r.n(i),s=r(6),l=r(215);t.default={data:function(){return{current:0,ruleForm:{declarationType:"",noUseNum:"",useComName:"",useComAddr:"",safeAdmin:"",propertyComTelephone:"",subList:[]},formDynamicPres:{items:[{eqVariety:"",registCode:"",eqCode:"",eqUseLocation:"",productNum:"",noUseReason:""}]},declarationTypeList:[{value:"停用",label:"停用"},{value:"报废",label:"报废"},{value:"注销",label:"注销"}],active:1,pdfUrl:"",rules:{},creatOrUpdate:!1}},components:{},computed:n()({},r.i(s.a)(["getSelectedOption","getRegistOne","getSelectedNum","getterUserData"])),watch:{"$route.query":function(){"/stopUseApp"==this.$route.path&&this.initData()}},methods:n()({},r.i(s.b)(["clearRegistOneForm","setRegistOneForm","getUserData"]),{handleAddPres:function(){this.formDynamicPres.items.push({eqVariety:"",registCode:"",eqCode:"",eqUseLocation:"",productNum:"",noUseReason:""}),this.ruleForm.subList=this.formDynamicPres.items},handleRemovePres:function(e){this.formDynamicPres.items.splice(e,1),this.ruleForm.subList=this.formDynamicPres.items},printTrigger:function(e){var t=document.getElementById(e);t.focus(),t.contentWindow.print()},setUserDetailData:function(){this.ruleForm.useComName=localStorage.getItem("useComName"),this.ruleForm.ruleForm.useComAddr=localStorage.getItem("useComAddr"),console.log(this.ruleForm.useComName)},initData:function(){this.active=1,this.current=0,this.creatOrUpdate=!1,this.device_type=this.$route.query.device_type,this.clearRuleForm(),this.formDynamicPres.items=[{eqVariety:"",registCode:"",eqCode:"",eqUseLocation:"",productNum:"",noUseReason:""}],this.setUserDetailData()},clearRuleForm:function(){this.ruleForm={declarationType:"",noUseNum:"",useComName:"",useComAddr:"",safeAdmin:"",propertyComTelephone:"",subList:[]}},submit:function(e){var t=this;l.b(e).then(function(e){200==e.status&&(t.applyId=e.data.applyId,t.fileId=e.data.forms.split("=")[1].split("}")[0],t.pdfUrl="/admin/file/preview?fileId="+t.fileId,t.$Message.info("您已提交信息，请预览结果"),t.modalCertain=!1)}).catch(function(e){console.log(e)})},submitContent:function(e){var t=this;this.$refs[e].validate(function(e){if(!e)return console.log("error submit!!"),t.$Message.info("尚有信息不符合要求，请检查"),!1;t.current++,t.active++;var r=(a()({},t.ruleForm),t.makeParams());t.submit(r)})},makeParams:function(){var e={};return this.ruleForm.eqSpecies=this.deviceCategoryId,this.ruleForm.eqCategory=this.deviceClassId,this.ruleForm.eqVariety=this.deviceClassTypeId,e.form5=this.ruleForm,e.acceptorAgencyId=1,this.device_type?e.deviceType=parseInt(this.device_type):e.deviceType=parseInt(this.$route.query.device_type),e.applyType=2,e.deviceCategory=this.deviceCategoryId,e.deviceClass=this.deviceClassId,e.deviceKind=this.deviceClassTypeId,e.deivceCode=this.ruleForm.eqCode,e.deivceName=this.ruleForm.eqName,e},updateContent:function(e){var t=this;this.$refs[e].validate(function(e){if(!e)return console.log("error submit!!"),t.$Message.info("尚有信息不符合要求，请检查"),!1;t.current++,t.active++;var r=(a()({},t.ruleForm),{});t.ruleForm.eqSpecies=t.deviceCategoryId,t.ruleForm.eqCategory=t.deviceClassId,t.ruleForm.eqVariety=t.deviceClassTypeId,r.form5=t.ruleForm,r.id=t.$route.query.applyId,r.deviceClass=t.deviceClassId,r.deviceKind=t.deviceClassTypeId,l.c(r).then(function(e){200==e.status&&(t.applyId=e.data.applyId,t.fileId=e.data.forms.split("=")[1].split("}")[0],t.pdfUrl="/admin/file/preview?fileId="+t.fileId,t.$Message.info("您已提交信息，请预览结果"),t.modalCertain=!1)}).catch(function(e){console.log(e)})})},next:function(){3==this.current?this.current=0:this.current+=1,this.active++},before:function(){this.current--,this.active--,this.creatOrUpdate=!0},confirmForm:function(){var e=this;1==this.$route.query.ifold||!0===this.creatOrUpdate?this.$Modal.confirm({title:"确认登记表信息",content:"<p>请确认全部填写信息</p>",onOk:function(){e.updateContent("ruleForm")},onCancel:function(){e.$Message.info("点击了取消")}}):this.$Modal.confirm({title:"确认登记表信息",content:"<p>请确认全部填写信息</p>",onOk:function(){e.submitContent("ruleForm")},onCancel:function(){e.$Message.info("点击了取消")}})}})}},341:function(e,t,r){t=e.exports=r(172)(!0),t.push([e.i,"@media print{.print[data-v-6232adf2]{display:block}.nprint[data-v-6232adf2]{display:none}}.setApp_topbar[data-v-6232adf2]{position:fixed;width:100%;margin:0;padding:0;height:80px;z-index:10;background-color:#fff}.base-box[data-v-6232adf2]{margin-left:0;display:block;border:2px solid #dddee1;border-top-left-radius:0;border-top-right-radius:0;border-bottom-right-radius:3px;border-bottom-left-radius:3px;width:100%;padding-left:100px;padding-right:100px;box-sizing:border-box;background-color:#fff}.header_one[data-v-6232adf2]{text-align:center;margin-left:-50px;margin-top:20px;font-size:25px}.header_two[data-v-6232adf2]{margin-left:-30px;margin-top:10px;font-size:19px}.setApp_button[data-v-6232adf2]{margin:10px}","",{version:3,sources:["/Users/zhangyunlong/Downloads/my-project/src/page/apply/stopUseApp/stopUseApp.vue"],names:[],mappings:"AACA,aACA,wBACI,aAAe,CAClB,AACD,yBACI,YAAc,CACjB,CACA,AACD,gCACE,eAAgB,AAChB,WAAY,AACZ,SAAY,AACZ,UAAa,AACb,YAAa,AACb,WAAY,AACZ,qBAAwB,CACzB,AACD,2BACE,cAAiB,AACjB,cAAe,AACf,yBAA0B,AAC1B,yBAA0B,AAC1B,0BAA2B,AAC3B,+BAAgC,AAChC,8BAA+B,AAC/B,WAAY,AACZ,mBAAoB,AACpB,oBAAqB,AACrB,sBAAuB,AACvB,qBAAwB,CACzB,AACD,6BACE,kBAAmB,AACnB,kBAAmB,AACnB,gBAAiB,AACjB,cAAgB,CACjB,AACD,6BACE,kBAAmB,AACnB,gBAAiB,AACjB,cAAgB,CACjB,AACD,gCACE,WAAa,CACd",file:"stopUseApp.vue",sourcesContent:["\n@media print {\n.print[data-v-6232adf2] {\n    display: block;\n}\n.nprint[data-v-6232adf2] {\n    display: none;\n}\n}\n.setApp_topbar[data-v-6232adf2] {\n  position: fixed;\n  width: 100%;\n  margin: 0px;\n  padding: 0px;\n  height: 80px;\n  z-index: 10;\n  background-color: white;\n}\n.base-box[data-v-6232adf2] {\n  margin-left: 0px;\n  display: block;\n  border: 2px solid #dddee1;\n  border-top-left-radius: 0;\n  border-top-right-radius: 0;\n  border-bottom-right-radius: 3px;\n  border-bottom-left-radius: 3px;\n  width: 100%;\n  padding-left: 100px;\n  padding-right: 100px;\n  box-sizing: border-box;\n  background-color: white;\n}\n.header_one[data-v-6232adf2] {\n  text-align: center;\n  margin-left: -50px;\n  margin-top: 20px;\n  font-size: 25px;\n}\n.header_two[data-v-6232adf2] {\n  margin-left: -30px;\n  margin-top: 10px;\n  font-size: 19px;\n}\n.setApp_button[data-v-6232adf2] {\n  margin: 10px;\n}\n"],sourceRoot:""}])},380:function(e,t,r){var o=r(341);"string"==typeof o&&(o=[[e.i,o,""]]),o.locals&&(e.exports=o.locals);r(173)("303d8527",o,!0)},421:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"stopUseApp"},[r("div",{staticClass:"setApp_topbar"},[r("div",{staticClass:"step",staticStyle:{width:"85%","margin-top":"20px"}},[r("Steps",{attrs:{current:e.current}},[r("Step",{attrs:{title:"步骤1",content:"填写《特种设备停用报废注销登记表》"}}),e._v(" "),r("Step",{attrs:{title:"步骤2",content:"预览《特种设备停用报废注销登记表》"}}),e._v(" "),r("Step",{attrs:{title:"步骤3",content:"完成申请"}})],1)],1)]),e._v(" "),r("div",{staticClass:"setApp_content",staticStyle:{position:"absolute",top:"85px"}},[r("Form",{ref:"ruleForm",attrs:{model:e.ruleForm,rules:e.rules,"label-width":110,"label-position":"left"}},[1==this.active?r("div",{staticClass:"statusInfo"},[r("div",{staticClass:"base-box"},[r("h2",{staticClass:"header_one"},[e._v("特种设备停用报废注销登记表")]),e._v(" "),r("h2",{staticClass:"header_two"},[e._v("设备基本情况")]),e._v(" "),r("Row",[r("Col",{attrs:{span:"11"}},[r("Form-item",{attrs:{label:"申报种类",prop:"declarationType"}},[r("Select",{model:{value:e.ruleForm.declarationType,callback:function(t){e.ruleForm.declarationType=t},expression:"ruleForm.declarationType"}},e._l(e.declarationTypeList,function(t){return r("Option",{key:t.value,attrs:{value:t.value}},[e._v(e._s(t.label)+"\n                ")])}))],1)],1),e._v(" "),r("Col",{attrs:{span:"11",offset:"2"}},[r("Form-item",{attrs:{label:"台数",prop:"noUseNum"}},[r("Input",{model:{value:e.ruleForm.noUseNum,callback:function(t){e.ruleForm.noUseNum=t},expression:"ruleForm.noUseNum"}})],1)],1)],1),e._v(" "),r("Form-item",{attrs:{label:"使用单位名称",prop:"useComName"}},[r("Input",{model:{value:e.ruleForm.useComName,callback:function(t){e.ruleForm.useComName=t},expression:"ruleForm.useComName"}})],1),e._v(" "),r("Form-item",{attrs:{label:"使用单位地址",prop:"useComAddr"}},[r("Input",{model:{value:e.ruleForm.useComAddr,callback:function(t){e.ruleForm.useComAddr=t},expression:"ruleForm.useComAddr"}})],1),e._v(" "),r("Row",[r("Col",{attrs:{span:"11"}},[r("Form-item",{attrs:{label:"安全管理员",prop:"safeAdmin"}},[r("Input",{model:{value:e.ruleForm.safeAdmin,callback:function(t){e.ruleForm.safeAdmin=t},expression:"ruleForm.safeAdmin"}})],1),e._v(" "),r("Form-item",{attrs:{label:"产权单位名称",prop:"propertyComName"}},[r("Input",{model:{value:e.ruleForm.propertyComName,callback:function(t){e.ruleForm.propertyComName=t},expression:"ruleForm.propertyComName"}})],1)],1),e._v(" "),r("Col",{attrs:{span:"11",offset:"2"}},[r("Form-item",{attrs:{label:"安全管理员联系电话",prop:"safeAdminTelephone"}},[r("Input",{model:{value:e.ruleForm.safeAdminTelephone,callback:function(t){e.ruleForm.safeAdminTelephone=t},expression:"ruleForm.safeAdminTelephone"}})],1),e._v(" "),r("Form-item",{attrs:{label:"产权单位联系电话",prop:"propertyComTelephone"}},[r("Input",{model:{value:e.ruleForm.propertyComTelephone,callback:function(t){e.ruleForm.propertyComTelephone=t},expression:"ruleForm.propertyComTelephone"}})],1)],1)],1),e._v(" "),e._l(e.formDynamicPres.items,function(t,o){return r("Form",{key:t.id,ref:"formDynamicPres",refInFor:!0,attrs:{model:e.formDynamicPres,"label-width":140,inline:""}},[r("Row",[r("Col",{attrs:{span:"8"}},[r("FormItem",{key:o,attrs:{label:"序号"+(o+1)+"  设备品种（名称）",prop:"items."+o+".value"}},[r("Input",{attrs:{type:"text",placeholder:"请输入..."},model:{value:t.eqVariety,callback:function(e){t.eqVariety=e},expression:"item.eqVariety"}})],1)],1),e._v(" "),r("Col",{attrs:{span:"8"}},[r("FormItem",{key:o,attrs:{label:"使用登记证编号",prop:"items."+o+".value"}},[r("Input",{attrs:{type:"text",placeholder:"请输入..."},model:{value:t.registCode,callback:function(e){t.registCode=e},expression:"item.registCode"}})],1)],1),e._v(" "),r("Col",{attrs:{span:"8"}},[r("FormItem",{key:o,attrs:{label:"设备代码",prop:"items."+o+".value"}},[r("Input",{attrs:{type:"text",placeholder:"请输入..."},model:{value:t.eqCode,callback:function(e){t.eqCode=e},expression:"item.eqCode"}})],1)],1)],1),e._v(" "),r("Row",[r("Col",{attrs:{span:"8"}},[r("FormItem",{key:o,attrs:{label:"设备使用地点",prop:"items."+o+".value"}},[r("Input",{attrs:{type:"text",placeholder:"请输入..."},model:{value:t.eqUseLocation,callback:function(e){t.eqUseLocation=e},expression:"item.eqUseLocation"}})],1)],1),e._v(" "),r("Col",{attrs:{span:"8"}},[r("FormItem",{key:o,attrs:{label:"产品编号",prop:"items."+o+".value"}},[r("Input",{attrs:{type:"text",placeholder:"请输入..."},model:{value:t.productNum,callback:function(e){t.productNum=e},expression:"item.productNum"}})],1)],1),e._v(" "),r("Col",{attrs:{span:"8"}},[r("FormItem",{key:o,attrs:{label:"停用注销报废原因",prop:"items."+o+".value"}},[r("Input",{attrs:{type:"text",placeholder:"请输入..."},model:{value:t.noUseReason,callback:function(e){t.noUseReason=e},expression:"item.noUseReason"}})],1)],1)],1),e._v(" "),r("FormItem",[r("Button",{attrs:{type:"dashed",long:"",icon:"plus-round"},on:{click:e.handleAddPres}},[e._v("新增")])],1),e._v(" "),r("FormItem",[r("Button",{attrs:{type:"ghost"},on:{click:function(t){e.handleRemovePres(o)}}},[e._v("删除")])],1),e._v(" "),r("br")],1)})],2)]):e._e(),e._v(" "),2==this.active?r("div",{staticClass:"setTable",staticStyle:{width:"900px",top:"30px",position:"absolute"}},[r("iframe",{staticStyle:{width:"100%",height:"1000px"},attrs:{id:"iFramePdf",src:this.pdfUrl}}),e._v(" "),r("Button",{attrs:{type:"warning"},on:{click:function(t){e.printTrigger("iFramePdf")}}},[e._v("打印")]),e._v(" "),2==this.active?r("Button",{attrs:{type:"primary"},on:{click:function(t){e.before()}}},[e._v("上一步")]):e._e(),e._v(" "),2==this.active?r("Button",{on:{click:function(t){e.instance("success")}}},[e._v("确认提交")]):e._e()],1):e._e(),e._v(" "),r("div",{staticClass:"setApp_button"},[1==this.active?r("Button",{attrs:{type:"primary"},on:{click:e.confirmForm}},[e._v("下一步")]):e._e()],1)])],1)])},staticRenderFns:[]}}});
//# sourceMappingURL=31.e95a3c15989408895768.js.map