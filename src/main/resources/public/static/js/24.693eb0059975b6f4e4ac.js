webpackJsonp([24],{213:function(e,t,a){function i(e){a(398)}var r=a(4)(a(319),a(439),i,"data-v-ed088cca",null);e.exports=r.exports},228:function(e,t,a){"use strict";function i(e){return a.i(d.a)("/apply/get",e,"post")}function r(e){return a.i(d.a)("/apply/delete?"+e,e,"get")}function o(e){return a.i(d.a)("/apply/get?"+e,e,"get")}function s(e){return a.i(d.a)("/api/getorders",e,"get")}function n(e){return a.i(d.a)("/api/getorders",e,"get")}function l(e){return a.i(d.a)("/api/getorders",e,"get")}function c(e){return a.i(d.a)("/api/getorders",e,"get")}t.e=i,t.g=r,t.f=o,t.a=s,t.b=n,t.c=l,t.d=c;var d=a(19)},229:function(e,t,a){"use strict";function i(e){return a.i(s.a)("/admin/unapprovedApplies/get",e,"post")}function r(e){return a.i(s.a)("/admin/approvedApplies/get",e,"post")}function o(e){return a.i(s.a)("/apply/get?"+e,e,"get")}t.b=i,t.d=r,t.c=o;var s=a(19)},319:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var i=a(13),r=a.n(i),o=a(6),s=a(228),n=a(229);t.default={data:function(){var e=this;return{List:[{value:"0",label:"待处理"},{value:"1",label:"已通过"},{value:"2",label:"已驳回"}],options:[{value:"one",label:"按台（套）申请",children:[{value:"boiler",label:"锅炉"},{value:"pressure",label:"压力容器（气瓶除外）"},{value:"elevator",label:"电梯"},{value:"hoisting",label:"起重机械"},{value:"cableway",label:"客运索道"},{value:"play",label:"大型游乐设施"},{value:"factorycar",label:"场 (厂)内专用机动车辆"},{value:"carbox",label:"车用气瓶"}]},{value:"two",label:"按单位申请",children:[{value:"cylinders",label:"气瓶(车用气瓶除外)"},{value:"pipeline",label:"工业管道"}]}],sort:[{value:"1",label:"首次申请"},{value:"2",label:"改造变更"},{value:"3",label:"移装变更"},{value:"4",label:"单位变更"},{value:"5",label:"更名变更"},{value:"6",label:"达到设计年限变更"},{value:"7",label:"停用申请"},{value:"8",label:"报废申请"}],model1:"",model2:"",columns5:[{title:"设备名称",key:"device"},{title:"日期",key:"time",sortable:!0},{title:"设备类别",key:"changeDevice"},{title:"申请类别",key:"changeApply"},{title:"受理机关",key:"accepter"},{title:"审批机关",key:"checker"},{title:"监管机关",key:"watcher"},{title:"订单状态",key:"orderState"},{title:"操作",key:"state",render:function(t,a){return t("div",[t("Button",{props:{type:"primary",size:"small"},style:{marginRight:"5px"},on:{click:function(){e.appDetail(a.index)}}},"详情")])}}],data5:[],state:{0:"待处理",1:"已通过",2:"已驳回"},params:{time:"",sort:"",state:"",page:1},time:"",num:200,orderState:""}},methods:r()({},a.i(o.b)({selectedDeviceOption:"selectedDeviceOption"}),{getOrders:function(e){var t=this;n.GetApprovaledOrders(e).then(function(e){if(e.success){t.data5=e.success,t.orderState=e.state,console.log(t.orderState);for(var a=0;a<t.data5.length;a++)t.data5[a].orderState=t.orderState}}).catch(function(e){console.log(e)})},changeTime:function(e){var t=this;console.log(e),s.a().then(function(e){e.success&&(t.data5=e.success)}).catch(function(e){console.log(e)})},changeState:function(e){var t=this;s.b(e).then(function(e){e.success&&(t.data5=e.success)}).catch(function(e){console.log(e)})},changeSort:function(e){var t=this;s.c(e).then(function(e){e.success&&(t.data5=e.success)}).catch(function(e){console.log(e)})},query:function(){var e=this;this.params.time=this.time,this.params.sort=this.model1,this.params.state=this.model2,console.log(this.params.state),s.d(this.params).then(function(t){t.success&&(e.data5=t.success)}).catch(function(e){console.log(e)})},initSize:function(e){var t=this;s.e(e).then(function(e){if(e.success){t.data5=e.success;for(var a=0;a<t.data5.length;a++)t.data5[a].state=t.state[t.data5[a].state]}}).catch(function(e){console.log(e)})},changeReq:function(e){this.$router.push({path:"changeReq",query:{dev_id:this.data5[e].id,dev_name:this.data5[e].device}})},appDetail:function(e){switch(this.data5[e].changeApplyNum){case 1:"one"==this.data5[e].changeDeviceNum[0]&&"carbox"!==this.data5[e].changeDeviceNum[1]?this.$router.push({path:"appDetail",query:{dev_id:this.data5[e].id,dev_name:this.data5[e].device,orderState:this.orderState}}):"two"==this.data5[e].changeDeviceNum[0]?this.$router.push({path:"comAppDetail",query:{dev_id:this.data5[e].id,dev_name:this.data5[e].device,orderState:this.orderState}}):"carbox"==this.data5[e].changeDeviceNum[1]&&this.$router.push({path:"carboxAppDetail",query:{dev_id:this.data5[e].id,dev_name:this.data5[e].device,orderState:this.orderState}});break;case 2:case 3:case 4:this.$router.push({path:"appDetail",query:{dev_id:this.data5[e].id,dev_name:this.data5[e].device,orderState:this.orderState}})}}}),computed:r()({},a.i(o.c)(["selectedOption"]),a.i(o.a)(["getSelectedOption"])),mounted:function(){this.getOrders(this.params.page)},watch:{$route:function(e,t){this.getOrders(this.params.page)}}}},359:function(e,t,a){t=e.exports=a(172)(!0),t.push([e.i,".filter-box[data-v-ed088cca]{display:block;border:1px solid #e5e5e5;border-top-left-radius:0;border-top-right-radius:0;border-bottom-right-radius:3px;border-bottom-left-radius:3px;padding:10px;box-sizing:border-box}.filter-box .query[data-v-ed088cca]{float:right;margin-right:60px;margin-top:10px}.list-box[data-v-ed088cca]{display:block;height:400px;border-top-left-radius:0;border-top-right-radius:0;border-bottom-right-radius:3px;border-bottom-left-radius:3px;margin-top:10px;box-sizing:border-box}.list-box .page[data-v-ed088cca]{float:right;margin:10px}","",{version:3,sources:["/Users/zhangyunlong/Downloads/my-project/src/page/supervision/supervision.vue"],names:[],mappings:"AACA,6BACE,cAAe,AACf,yBAA0B,AAC1B,yBAA0B,AAC1B,0BAA2B,AAC3B,+BAAgC,AAChC,8BAA+B,AAC/B,aAAc,AACd,qBAAuB,CACxB,AACD,oCACI,YAAa,AACb,kBAAmB,AACnB,eAAiB,CACpB,AACD,2BACE,cAAe,AACf,aAAc,AACd,yBAA0B,AAC1B,0BAA2B,AAC3B,+BAAgC,AAChC,8BAA+B,AAC/B,gBAAiB,AACjB,qBAAuB,CACxB,AACD,iCACI,YAAa,AACb,WAAa,CAChB",file:"supervision.vue",sourcesContent:["\n.filter-box[data-v-ed088cca] {\n  display: block;\n  border: 1px solid #e5e5e5;\n  border-top-left-radius: 0;\n  border-top-right-radius: 0;\n  border-bottom-right-radius: 3px;\n  border-bottom-left-radius: 3px;\n  padding: 10px;\n  box-sizing: border-box;\n}\n.filter-box .query[data-v-ed088cca] {\n    float: right;\n    margin-right: 60px;\n    margin-top: 10px;\n}\n.list-box[data-v-ed088cca] {\n  display: block;\n  height: 400px;\n  border-top-left-radius: 0;\n  border-top-right-radius: 0;\n  border-bottom-right-radius: 3px;\n  border-bottom-left-radius: 3px;\n  margin-top: 10px;\n  box-sizing: border-box;\n}\n.list-box .page[data-v-ed088cca] {\n    float: right;\n    margin: 10px;\n}\n"],sourceRoot:""}])},398:function(e,t,a){var i=a(359);"string"==typeof i&&(i=[[e.i,i,""]]),i.locals&&(e.exports=i.locals);a(173)("18c2d8b0",i,!0)},439:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"supervision"},[a("div",{staticClass:"filter-box"},[a("Row",[a("Col",{attrs:{xs:8,sm:8,md:8,lg:8}},[a("label",[e._v("设备申请时间")]),e._v(" "),a("Date-picker",{staticStyle:{width:"220px",display:"inline-block"},attrs:{type:"daterange",placeholder:"选择日期",format:"yyyy/MM/dd"},on:{"on-change":e.changeTime},model:{value:e.time,callback:function(t){e.time=t},expression:"time"}})],1),e._v(" "),a("Col",{attrs:{xs:8,sm:8,md:8,lg:8}},[a("label",[e._v("设备类别")]),e._v(" "),a("Cascader",{staticStyle:{width:"200px",display:"inline-block"},attrs:{data:e.options,trigger:"hover"},on:{"on-change":e.changeState}})],1),e._v(" "),a("Col",{attrs:{xs:8,sm:8,md:8,lg:8}},[a("label",[e._v("申请类别")]),e._v(" "),a("Select",{staticStyle:{width:"200px"},on:{"on-change":e.changeSort},model:{value:e.model2,callback:function(t){e.model2=t},expression:"model2"}},e._l(e.sort,function(t){return a("Option",{key:t.value,attrs:{value:t.value}},[e._v(" "+e._s(t.label))])}))],1),e._v(" "),a("Button",{staticClass:"query",attrs:{type:"primary"},on:{click:e.query}},[e._v("查询")])],1)],1),e._v(" "),a("div",{staticClass:"list-box"},[a("Table",{attrs:{border:"",columns:e.columns5,data:e.data5}}),e._v(" "),a("Page",{staticClass:"page",attrs:{total:this.num,size:"small","show-elevator":""},on:{"on-change":e.initSize}})],1)])},staticRenderFns:[]}}});
//# sourceMappingURL=24.693eb0059975b6f4e4ac.js.map