webpackJsonp([6],{179:function(e,t,o){function r(e){o(306)}var l=o(5)(o(228),o(339),r,"data-v-64ebf74d",null);e.exports=l.exports},203:function(e,t,o){"use strict";function r(e){return o.i(f.a)("/apply/create",e,"post")}function l(e){return o.i(f.a)("/apply/drop",e,"post")}function a(e){return o.i(f.a)("/apply/disable",e,"post")}function n(e){return o.i(f.a)("/user/update",e,"post")}function s(e){return o.i(f.a)("/apply/update",e,"post")}function c(e){return o.i(f.a)("/api/submitSetInfo",e,"post")}function i(e){return o.i(f.a)("/static/deviceClass?"+e,e,"get")}function u(e){return o.i(f.a)("/static/deviceType?"+e,e,"get")}function m(e){return o.i(f.a)("/map/provinces",e,"get")}function p(e){return o.i(f.a)("/map/cities?"+e,e,"get")}function d(e){return o.i(f.a)("/map/areas?"+e,e,"get")}function _(e){return o.i(f.a)("/apply/get?"+e,e,"get")}function h(e){return o.i(f.a)("/apply/confirm?"+e,e,"get")}function v(e){return o.i(f.a)("/map/organization?"+e,e,"get")}t.f=r,t.l=l,t.k=a,t.n=n,t.g=s,t.j=c,t.m=i,t.i=u,t.a=m,t.b=p,t.c=d,t.e=_,t.h=h,t.d=v;var f=o(32)},204:function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),t.default={name:"detailPdf",props:["pdfUrl","pdfNum"],data:function(){return{pdfToggle:[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]}},methods:{writepdf:function(){if(0==this.pdfToggle.length)for(var e=0;e<this.pdfNum;e++)this.pdfToggle[e]=1},test:function(e){this.writepdf(),1==this.pdfToggle[e]?this.pdfToggle.splice(e,1,0):0==this.pdfToggle[e]&&this.pdfToggle.splice(e,1,1)}}}},205:function(e,t,o){t=e.exports=o(168)(!0),t.push([e.i,".detail_li[data-v-09875984]{margin:10px;font-size:small}","",{version:3,sources:["/Users/zhangyunlong/Downloads/my-project/src/components/detailpdf/detailPdf.vue"],names:[],mappings:"AACA,4BACE,YAAa,AACb,eAAiB,CAClB",file:"detailPdf.vue",sourcesContent:["\n.detail_li[data-v-09875984] {\n  margin: 10px;\n  font-size: small;\n}\n"],sourceRoot:""}])},206:function(e,t,o){var r=o(205);"string"==typeof r&&(r=[[e.i,r,""]]),r.locals&&(e.exports=r.locals);o(169)("6e9ce622",r,!0)},207:function(e,t,o){function r(e){o(206)}var l=o(5)(o(204),o(208),r,"data-v-09875984",null);e.exports=l.exports},208:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"detailPdf"},[o("ul",{staticClass:"detail_ul"},e._l(e.pdfUrl,function(t,r,l){return o("li",{staticClass:"detail_li"},[o("a",{staticClass:"detail_a",attrs:{href:"/file/download?fileId="+t,download:"key"}},[e._v(e._s(r.replace(/\d+/g,""))+".pdf")]),e._v(" "),1==e.pdfToggle[l]?o("Button",{attrs:{type:"ghost",size:"small"},on:{click:function(t){e.test(l)}}},[o("Icon",{attrs:{type:"eye"}}),e._v("\n        预览\n      ")],1):o("Button",{attrs:{type:"ghost",size:"small"},on:{click:function(t){e.test(l)}}},[o("Icon",{attrs:{type:"chevron-down"}}),e._v("\n        收起\n      ")],1),e._v(" "),0==e.pdfToggle[l]?o("embed",{attrs:{src:"/file/preview?fileId="+t,width:"100%",height:"1000px"}}):e._e()],1)}))])},staticRenderFns:[]}},228:function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=o(64),l=o.n(r),a=o(13),n=o.n(a),s=o(207),c=(o.n(s),o(6)),i=o(203);t.default={data:function(){return{ruleForm:{},rules:{},ifNext:!0,active:1,selected:"",imgName:"",visible:!1,uploadList:[],modal1:!1,author_key:"",defaultPdfList1:[],selectedNum:"",deviceNum:1,ruleForms:"",previousNum:0,value1:""}},components:{"v-regist_one":regist_one},watch:{$route:"initData"},computed:n()({},o.i(c.a)(["getSelectedOption","getRegistOne","getSelectedNum"])),mounted:function(){this.initData(),this.author_key=localStorage.getItem("author_key")},methods:n()({},o.i(c.b)({clearRegistOneForm:"clearRegistOneForm"}),{initData:function(){var e=this;this.deviceNum=1,this.active=1,this.selected=this.getSelectedOption,this.selectedNum=this.getSelectedNum,this.$route.query.changeDeviceNum?registService.getRegistOne(this.$route.query.dev_id).then(function(t){e.ruleForms=t.success,e.ruleForm=e.ruleForms.ruleForm[0],e.defaultPdfList1=t.pdfUrlDefault,console.log(t)}).catch(function(e){console.log(e)}):(this.clearRegistOneForm(),this.ruleForm=this.getRegistOne,this.defaultPdfList1=[])},submitForm:function(e){var t=this;this.$refs[e].validate(function(e){if(!e)return console.log("error submit!!"),!1;var o=l()({},t.ruleForm);o.selected=t.selected,t.ifNext=!1,i.f(o).then(function(e){e&&console.log(e.success)}).catch(function(e){console.log(e)})})},saveForm:function(e){var t=this;this.$refs[e].validate(function(e){if(!e)return console.log("error submit!!"),!1;var o=l()({},t.ruleForm);o.selected=t.selected,console.log(o),t.ifNext=!1,i.j(o).then(function(e){e&&console.log(e.success)}).catch(function(e){console.log(e)})})},resetForm:function(e){this.$refs[e].resetFields()},next:function(e){this.$refs[e].validate(function(e){}),1==this.active&&this.submitForm("ruleForm"),this.beSure()},before:function(){1==this.active?this.$route.query.changeDeviceNum?this.$router.push({path:"firstApp",query:{dev_id:this.$route.query.dev_id,dev_name:this.$route.query.dev_name,changeDeviceNum:this.$route.query.changeDeviceNum,selectedNum:this.getSelectedNum}}):this.$router.push({path:"firstApp",query:{changeDeviceNum:this.getSelectedOption,selectedNum:this.getSelectedNum}}):this.active--},beSure:function(){if(this.deviceNum<this.selectedNum){if(this.ruleForms&&this.selectedNum>this.ruleForms.ruleForm.length)for(var e=this.ruleForms.ruleForm.length,t=0;t<this.selectedNum-e;t++)this.ruleForms.ruleForm[this.ruleForms.ruleForm.length]={};this.deviceNum++,this.active=1,this.$Modal.success({content:"请继续填写下一台(套)的登记表"}),this.ruleForms?this.ruleForm=this.ruleForms.ruleForm[this.deviceNum-1]:(this.clearRegistOneForm(),this.ruleForm=this.getRegistOne)}else this.active=2},handleBeforeUpload:function(){this.uploadList=this.$refs.upload.fileList;var e=this.uploadList.length<1;return e||this.$Notice.warning({title:"最多上传 1 张图片。"}),e},handleSuccess:function(e,t){console.log(e),console.log(t)},handleRemove:function(e,t){console.log(e),console.log(t)},instance:function(e){switch(e){case"success":this.$Modal.success({title:"通知",content:"<p>您已经成功提交申请</p><p>请耐心等待受理结果</p>"})}this.$router.push("home")}})}},273:function(e,t,o){t=e.exports=o(168)(!0),t.push([e.i,"@media print{.print[data-v-64ebf74d]{display:block}.nprint[data-v-64ebf74d]{display:none}}.setApp[data-v-64ebf74d]{color:#495060}","",{version:3,sources:["/Users/zhangyunlong/Downloads/my-project/src/page/apply/avaiableDev/changeReq/transformChange.vue"],names:[],mappings:"AACA,aACA,wBACI,aAAe,CAClB,AACD,yBACI,YAAc,CACjB,CACA,AACD,yBACE,aAAe,CAChB",file:"transformChange.vue",sourcesContent:["\n@media print {\n.print[data-v-64ebf74d] {\n    display: block;\n}\n.nprint[data-v-64ebf74d] {\n    display: none;\n}\n}\n.setApp[data-v-64ebf74d] {\n  color: #495060;\n}\n"],sourceRoot:""}])},306:function(e,t,o){var r=o(273);"string"==typeof r&&(r=[[e.i,r,""]]),r.locals&&(e.exports=r.locals);o(169)("6da8d55b",r,!0)},339:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"transformChange"},[o("Form",{ref:"ruleForm",attrs:{model:e.ruleForm,rules:e.rules,"label-width":100,inline:""}},[o("h2"),e._v(" "),1==this.active?o("div",{staticClass:"statusInfo"},[o("h2",[e._v("改造变更")]),e._v(" "),o("h2",[e._v("设备基本情况")]),e._v(" "),o("Form-item",{attrs:{label:"设备种类",prop:"eq_species"}},[o("Input",{attrs:{placeholder:"请输入设备种类"},model:{value:e.ruleForm.eq_species,callback:function(t){e.ruleForm.eq_species=t},expression:"ruleForm.eq_species"}})],1),e._v(" "),o("Form-item",{attrs:{label:"设备类别",prop:"eq_category"}},[o("Input",{attrs:{placeholder:"请输入设备类别"},model:{value:e.ruleForm.eq_category,callback:function(t){e.ruleForm.eq_category=t},expression:"ruleForm.eq_category"}})],1),e._v(" "),o("Form-item",{attrs:{label:"设备品种",prop:"eq_variety"}},[o("Input",{attrs:{placeholder:"请输入设备品种"},model:{value:e.ruleForm.eq_variety,callback:function(t){e.ruleForm.eq_variety=t},expression:"ruleForm.eq_variety"}})],1),e._v(" "),o("Form-item",{attrs:{label:"产品名称",prop:"eq_name"}},[o("Input",{attrs:{placeholder:"请输入产品名称"},model:{value:e.ruleForm.eq_name,callback:function(t){e.ruleForm.eq_name=t},expression:"ruleForm.eq_name"}})],1),e._v(" "),o("Form-item",{attrs:{label:"设备代码",prop:"eq_code"}},[o("Input",{attrs:{placeholder:"请输入设备代码"},model:{value:e.ruleForm.eq_code,callback:function(t){e.ruleForm.eq_code=t},expression:"ruleForm.eq_code"}})],1),e._v(" "),o("Form-item",{attrs:{label:"型号（规格）",prop:"model"}},[o("Input",{attrs:{placeholder:"请输入型号（规格）"},model:{value:e.ruleForm.model,callback:function(t){e.ruleForm.model=t},expression:"ruleForm.model"}})],1),e._v(" "),o("Form-item",{attrs:{label:"设计使用年限",prop:"design_use_limit"}},[o("Input",{attrs:{placeholder:"请输入设计使用年限"},model:{value:e.ruleForm.design_use_limit,callback:function(t){e.ruleForm.design_use_limit=t},expression:"ruleForm.design_use_limit"}})],1),e._v(" "),o("Form-item",{attrs:{label:"设计单位名称",prop:"design_com_name"}},[o("Input",{attrs:{placeholder:"请输入设计单位名称"},model:{value:e.ruleForm.design_com_name,callback:function(t){e.ruleForm.design_com_name=t},expression:"ruleForm.design_com_name"}})],1),e._v(" "),o("Form-item",{attrs:{label:"制造单位名称",prop:"manufacture_com_name"}},[o("Input",{attrs:{placeholder:"请输入制造单位名称"},model:{value:e.ruleForm.manufacture_com_name,callback:function(t){e.ruleForm.manufacture_com_name=t},expression:"ruleForm.manufacture_com_name"}})],1),e._v(" "),o("Form-item",{attrs:{label:"施工单位名称",prop:"construct_com_name"}},[o("Input",{attrs:{placeholder:"请输入施工单位名称"},model:{value:e.ruleForm.construct_com_name,callback:function(t){e.ruleForm.construct_com_name=t},expression:"ruleForm.construct_com_name"}})],1),e._v(" "),o("Form-item",{attrs:{label:"监督检验机构名称",prop:"supervise_com_name"}},[o("Input",{attrs:{placeholder:"请输入监督检验机构名称"},model:{value:e.ruleForm.supervise_com_name,callback:function(t){e.ruleForm.supervise_com_name=t},expression:"ruleForm.supervise_com_name"}})],1),e._v(" "),o("Form-item",{attrs:{label:"型式试验机构名称",prop:"test_com_name"}},[o("Input",{attrs:{placeholder:"请输入型式试验机构名称"},model:{value:e.ruleForm.test_com_name,callback:function(t){e.ruleForm.test_com_name=t},expression:"ruleForm.test_com_name"}})],1),e._v(" "),o("h2",[e._v("设备使用情况")]),e._v(" "),o("Form-item",{attrs:{label:"使用单位名称",prop:"use_com_name"}},[o("Input",{attrs:{placeholder:"请输入使用单位名称"},model:{value:e.ruleForm.use_com_name,callback:function(t){e.ruleForm.use_com_name=t},expression:"ruleForm.use_com_name"}})],1),e._v(" "),o("Form-item",{attrs:{label:"使用单位地址",prop:"use_com_addr"}},[o("Input",{attrs:{placeholder:"请输入使用单位地址"},model:{value:e.ruleForm.use_com_addr,callback:function(t){e.ruleForm.use_com_addr=t},expression:"ruleForm.use_com_addr"}})],1),e._v(" "),o("Form-item",{attrs:{label:"使用单位统一社会信用代码",prop:"use_com_code"}},[o("Input",{attrs:{placeholder:"请输入使用单位统一社会信用代码"},model:{value:e.ruleForm.use_com_code,callback:function(t){e.ruleForm.use_com_code=t},expression:"ruleForm.use_com_code"}})],1),e._v(" "),o("Form-item",{attrs:{label:"邮政编码",prop:"zip_code"}},[o("Input",{attrs:{placeholder:"请输入邮政编码"},model:{value:e.ruleForm.zip_code,callback:function(t){e.ruleForm.zip_code=t},expression:"ruleForm.zip_code"}})],1),e._v(" "),o("Form-item",{attrs:{label:"单位内编号",prop:"com_code"}},[o("Input",{attrs:{placeholder:"请输入单位内编号"},model:{value:e.ruleForm.com_code,callback:function(t){e.ruleForm.com_code=t},expression:"ruleForm.com_code"}})],1),e._v(" "),o("Form-item",{attrs:{label:"设备使用地点",prop:"eq_use_location"}},[o("Input",{attrs:{placeholder:"请输入设备使用地点"},model:{value:e.ruleForm.eq_use_location,callback:function(t){e.ruleForm.eq_use_location=t},expression:"ruleForm.eq_use_location"}})],1),e._v(" "),o("Form-item",{attrs:{label:"投入使用日期",prop:"begin_use_date"}},[o("Input",{attrs:{placeholder:"请输入投入使用日期"},model:{value:e.ruleForm.begin_use_date,callback:function(t){e.ruleForm.begin_use_date=t},expression:"ruleForm.begin_use_date"}})],1),e._v(" "),o("Form-item",{attrs:{label:"单位固定电话",prop:"com_phone"}},[o("Input",{attrs:{placeholder:"请输入单位固定电话"},model:{value:e.ruleForm.com_phone,callback:function(t){e.ruleForm.com_phone=t},expression:"ruleForm.com_phone"}})],1),e._v(" "),o("Form-item",{attrs:{label:"安全管理员",prop:"safe_admin"}},[o("Input",{attrs:{placeholder:"请输入安全管理员"},model:{value:e.ruleForm.safe_admin,callback:function(t){e.ruleForm.safe_admin=t},expression:"ruleForm.safe_admin"}})],1),e._v(" "),o("Form-item",{attrs:{label:"移动电话",prop:"mobile_phone"}},[o("Input",{attrs:{placeholder:"请输入移动电话"},model:{value:e.ruleForm.mobile_phone,callback:function(t){e.ruleForm.mobile_phone=t},expression:"ruleForm.mobile_phone"}})],1),e._v(" "),o("Form-item",{attrs:{label:"产权单位名称",prop:"property_com_name"}},[o("Input",{attrs:{placeholder:"请输入产权单位名称"},model:{value:e.ruleForm.property_com_name,callback:function(t){e.ruleForm.property_com_name=t},expression:"ruleForm.property_com_name"}})],1),e._v(" "),o("Form-item",{attrs:{label:"产权单位统一社会信用代码",prop:"property_com_code"}},[o("Input",{attrs:{placeholder:"请输入产权单位统一社会信用代码"},model:{value:e.ruleForm.property_com_code,callback:function(t){e.ruleForm.property_com_code=t},expression:"ruleForm.property_com_code"}})],1),e._v(" "),o("Form-item",{attrs:{label:"联系电话",prop:"telephone"}},[o("Input",{attrs:{placeholder:"请输入联系电话"},model:{value:e.ruleForm.telephone,callback:function(t){e.ruleForm.telephone=t},expression:"ruleForm.telephone"}})],1),e._v(" "),o("h2",[e._v("设备检验情况")]),e._v(" "),o("Form-item",{attrs:{label:"检验机构名称",prop:"check_com_name"}},[o("Input",{attrs:{placeholder:"请输入检验机构名称"},model:{value:e.ruleForm.check_com_name,callback:function(t){e.ruleForm.check_com_name=t},expression:"ruleForm.check_com_name"}})],1),e._v(" "),o("Form-item",{attrs:{label:"检验类别",prop:"check_category"}},[o("Input",{attrs:{placeholder:"请输入检验类别"},model:{value:e.ruleForm.check_category,callback:function(t){e.ruleForm.check_category=t},expression:"ruleForm.check_category"}})],1),e._v(" "),o("Form-item",{attrs:{label:"检验报告编号",prop:"check_report_num"}},[o("Input",{attrs:{placeholder:"请输入检验报告编号"},model:{value:e.ruleForm.check_report_num,callback:function(t){e.ruleForm.check_report_num=t},expression:"ruleForm.check_report_num"}})],1),e._v(" "),o("Form-item",{attrs:{label:"检验日期",prop:"check_date"}},[o("Input",{attrs:{placeholder:"请输入检验日期"},model:{value:e.ruleForm.check_date,callback:function(t){e.ruleForm.check_date=t},expression:"ruleForm.check_date"}})],1),e._v(" "),o("Form-item",{attrs:{label:"检验结论",prop:"check_conclusion"}},[o("Input",{attrs:{placeholder:"请输入检验结论"},model:{value:e.ruleForm.check_conclusion,callback:function(t){e.ruleForm.check_conclusion=t},expression:"ruleForm.check_conclusion"}})],1),e._v(" "),o("Form-item",{attrs:{label:"下次检验日期",prop:"next_check_date"}},[o("Input",{attrs:{placeholder:"请输入下次检验日期"},model:{value:e.ruleForm.next_check_date,callback:function(t){e.ruleForm.next_check_date=t},expression:"ruleForm.next_check_date"}})],1)],1):e._e(),e._v(" "),1==this.active?o("div",{staticClass:"setTable"},[o("Alert",{attrs:{closable:""}},[e._v("请确认表格信息是否全部正确")]),e._v(" "),o("Collapse",{model:{value:e.value1,callback:function(t){e.value1=t},expression:"value1"}},[o("Panel",{attrs:{name:"1"}},[o("span",{staticClass:"panel_content"},[e._v("特种设备使用登记表")]),e._v(" "),o("div",{slot:"content"},[o("v-regist_one",{attrs:{ruleForm:e.ruleForm}}),e._v(" "),1==this.active?o("Button",{on:{click:function(t){e.addElecSeal()}}},[e._v("添加")]):e._e()],1)])],1)],1):e._e(),e._v(" "),2==this.active?o("div",{staticClass:"pdfInfo"},[o("h2",[e._v("相关证明")]),e._v(" "),o("Form-item",{attrs:{label:"原使用登记证","label-width":300}},[o("Upload",{attrs:{action:"//jsonplaceholder.typicode.com/posts/","on-success":e.handleSuccess,"with-credentials":""}},[o("Button",{attrs:{type:"ghost",icon:"ios-cloud-upload-outline"}},[e._v("上传文件")])],1)],1),e._v(" "),o("Form-item",{attrs:{label:"改造质量证明资料","label-width":300}},[o("Upload",{attrs:{action:"//jsonplaceholder.typicode.com/posts/","on-success":e.handleSuccess,"with-credentials":""}},[o("Button",{attrs:{type:"ghost",icon:"ios-cloud-upload-outline"}},[e._v("上传文件")])],1)],1),e._v(" "),o("Form-item",{attrs:{label:"改造监督检验证书","label-width":300}},[o("Upload",{attrs:{action:"//jsonplaceholder.typicode.com/posts/","on-success":e.handleSuccess,"with-credentials":""}},[o("Button",{attrs:{type:"ghost",icon:"ios-cloud-upload-outline"}},[e._v("上传文件")])],1)],1)],1):e._e(),e._v(" "),this.active<2?o("Button",{attrs:{type:"primary"},on:{click:function(t){e.next("ruleForm")}}},[e._v("下一步")]):e._e(),e._v(" "),2==this.active?o("Button",{on:{click:function(t){e.instance("success")}}},[e._v("确认提交")]):e._e(),e._v(" "),this.active<2?o("Button",{staticStyle:{"margin-left":"8px"},attrs:{type:"ghost"},on:{click:function(t){e.resetForm("ruleForm")}}},[e._v("重置")]):e._e(),e._v(" "),this.active<2?o("Button",{staticStyle:{"margin-left":"8px"},attrs:{type:"ghost"},on:{click:function(t){e.saveForm("ruleForm")}}},[e._v("保存")]):e._e()],1)],1)},staticRenderFns:[]}}});
//# sourceMappingURL=6.03a4aa2b9a6074ade811.js.map