webpackJsonp([13],{170:function(t,a,e){function n(t){e(300)}var o=e(5)(e(219),e(333),n,"data-v-58ac5fba",null);t.exports=o.exports},213:function(t,a,e){"use strict";Object.defineProperty(a,"__esModule",{value:!0}),a.default={name:"breadCrumb",props:["bread_choose"],data:function(){return{}},method:{}}},215:function(t,a,e){a=t.exports=e(168)(!0),a.push([t.i,"","",{version:3,sources:[],names:[],mappings:"",file:"breadCrumb.vue",sourceRoot:""}])},216:function(t,a,e){var n=e(215);"string"==typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);e(169)("769a0950",n,!0)},217:function(t,a,e){function n(t){e(216)}var o=e(5)(e(213),e(218),n,"data-v-60f5ecba",null);t.exports=o.exports},218:function(t,a){t.exports={render:function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"breadCrumb"},[e("Breadcrumb",[e("BreadcrumbItem",{attrs:{href:"/home"}},[t._v("首页")]),t._v(" "),e("BreadcrumbItem",[t._v("首次申请")]),t._v(" "),e("BreadcrumbItem",[t._v(t._s(t.bread_choose))])],1)],1)},staticRenderFns:[]}},219:function(t,a,e){"use strict";Object.defineProperty(a,"__esModule",{value:!0});var n=e(13),o=e.n(n),i=e(20),r=e.n(i),A=e(34),s=e.n(A),l=e(217),u=e.n(l),d=e(6),p=e(35),v=e.n(p);a.default={data:function(){return{author_key:""}},computed:o()({defaultActive:function(){return this.$route.path.replace("/","")}},e.i(d.a)(["headShow"])),mounted:function(){this.author_key=localStorage.getItem("author_key")},components:{VLogin:v.a,"v-header":r.a,"v-footer":s.a,"v-breadCrumb":u.a},methods:o()({routeTo:function(t){var a=t.split("-");if("newOrLast"==a[0]){var e=a[0],n=a[1];this.$router.push({path:e,query:{device_type:n}})}else if("applyerList"==a[0]){var o=a[0],i=a[1];this.$router.push({path:o,query:{apply_state:i}})}else if("devList"==a[0]){var r=a[0],A=a[1];this.$router.push({path:r,query:{apply_state:A}})}else{var s=a[0];this.$router.push({path:s})}}},e.i(d.b)(["getUserInfo"]))}},267:function(t,a,e){a=t.exports=e(168)(!0),a.push([t.i,"@media print{.print[data-v-58ac5fba]{display:block}.nprint[data-v-58ac5fba]{display:none}}.layout[data-v-58ac5fba]{border:1px solid #d7dde4;background:#f5f7f9;position:relative;height:100%}.layout-breadcrumb[data-v-58ac5fba]{padding:10px 15px 0}.layout-content[data-v-58ac5fba]{min-height:200px;margin:10px;overflow:scroll;background:#fff;border-radius:4px;position:absolute;left:0;top:60px;bottom:30px;right:0;height:auto}.layout-content-main[data-v-58ac5fba]{padding:10px;padding-top:0}.layout-copy[data-v-58ac5fba]{text-align:center;color:#9ea7b4;position:fixed;z-index:100;left:300px;height:30px;right:0;bottom:0}.layout-menu-left[data-v-58ac5fba]{background:#464c5b;height:100%;overflow:scroll}.layout-header[data-v-58ac5fba]{height:60px;background:#fff;box-shadow:0 1px 1px rgba(0,0,0,.1)}.layout-logo-left[data-v-58ac5fba]{width:16.7%;height:60px;background:#fff;border-radius:3px;padding:10px;padding-left:17px}.layout-logo-left .logo-head[data-v-58ac5fba]{font-size:1.4vw;margin-left:.2rem;color:#464c5b}.ivu-row-flex[data-v-58ac5fba]{height:100%}.menu-label[data-v-58ac5fba]{color:hsla(0,0%,100%,.36);display:inline-block;margin-top:10px;margin-left:10px;font-size:18px}.ivu-menu-dark.ivu-menu-vertical .ivu-menu-item[data-v-58ac5fba],.ivu-menu-dark.ivu-menu-vertical .ivu-menu-submenu-title[data-v-58ac5fba]{font-size:16px}.content[data-v-58ac5fba]{background:none repeat scroll 0 0 #f8f8f9;border-color:#80848f;position:absolute;left:240px;right:0;top:66px;bottom:3rem;padding:25px 40px;box-sizing:border-box;overflow-y:scroll;margin:0}.ivu-menu-vertical .ivu-menu-submenu .ivu-menu-item[data-v-58ac5fba]{padding-left:43px;padding-top:5px;padding-bottom:5px}.menu-content[data-v-58ac5fba]::-webkit-scrollbar{display:none}","",{version:3,sources:["/Users/zhangyunlong/Downloads/my-project/src/components/home/home.vue"],names:[],mappings:"AACA,aACA,wBACI,aAAe,CAClB,AACD,yBACI,YAAc,CACjB,CACA,AACD,yBACE,yBAA0B,AAC1B,mBAAoB,AACpB,kBAAmB,AACnB,WAAa,CACd,AACD,oCACE,mBAAqB,CACtB,AACD,iCACE,iBAAkB,AAClB,YAAa,AACb,gBAAiB,AACjB,gBAAiB,AACjB,kBAAmB,AACnB,kBAAmB,AACnB,OAAQ,AACR,SAAU,AACV,YAAa,AACb,QAAS,AACT,WAAa,CACd,AACD,sCACE,aAAc,AACd,aAAe,CAChB,AACD,8BACE,kBAAmB,AACnB,cAAe,AACf,eAAgB,AAChB,YAAa,AACb,WAAY,AACZ,YAAa,AACb,QAAS,AACT,QAAU,CACX,AACD,mCACE,mBAAoB,AACpB,YAAa,AACb,eAAiB,CAClB,AACD,gCACE,YAAa,AACb,gBAAiB,AACjB,mCAAyC,CAC1C,AACD,mCACE,YAAa,AACb,YAAa,AACb,gBAAiB,AACjB,kBAAmB,AACnB,aAAc,AACd,iBAAmB,CACpB,AACD,8CACI,gBAAiB,AACjB,kBAAoB,AACpB,aAAe,CAClB,AACD,+BACE,WAAa,CACd,AACD,6BACE,0BAAiC,AACjC,qBAAsB,AACtB,gBAAiB,AACjB,iBAAkB,AAClB,cAAgB,CACjB,AACD,2IACE,cAAgB,CACjB,AACD,0BACE,0CAA2C,AAC3C,qBAAsB,AACtB,kBAAmB,AACnB,WAAY,AACZ,QAAS,AACT,SAAU,AACV,YAAa,AACb,kBAA6B,AAC7B,sBAAuB,AACvB,kBAAmB,AACnB,QAAU,CACX,AACD,qEACE,kBAAmB,AACnB,gBAAiB,AACjB,kBAAoB,CACrB,AACD,kDACE,YAAc,CACf",file:"home.vue",sourcesContent:["\n@media print {\n.print[data-v-58ac5fba] {\n    display: block;\n}\n.nprint[data-v-58ac5fba] {\n    display: none;\n}\n}\n.layout[data-v-58ac5fba] {\n  border: 1px solid #d7dde4;\n  background: #f5f7f9;\n  position: relative;\n  height: 100%;\n}\n.layout-breadcrumb[data-v-58ac5fba] {\n  padding: 10px 15px 0;\n}\n.layout-content[data-v-58ac5fba] {\n  min-height: 200px;\n  margin: 10px;\n  overflow: scroll;\n  background: #fff;\n  border-radius: 4px;\n  position: absolute;\n  left: 0;\n  top: 60px;\n  bottom: 30px;\n  right: 0;\n  height: auto;\n}\n.layout-content-main[data-v-58ac5fba] {\n  padding: 10px;\n  padding-top: 0;\n}\n.layout-copy[data-v-58ac5fba] {\n  text-align: center;\n  color: #9ea7b4;\n  position: fixed;\n  z-index: 100;\n  left: 300px;\n  height: 30px;\n  right: 0;\n  bottom: 0;\n}\n.layout-menu-left[data-v-58ac5fba] {\n  background: #464c5b;\n  height: 100%;\n  overflow: scroll;\n}\n.layout-header[data-v-58ac5fba] {\n  height: 60px;\n  background: #fff;\n  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);\n}\n.layout-logo-left[data-v-58ac5fba] {\n  width: 16.7%;\n  height: 60px;\n  background: #fff;\n  border-radius: 3px;\n  padding: 10px;\n  padding-left: 17px;\n}\n.layout-logo-left .logo-head[data-v-58ac5fba] {\n    font-size: 1.4vw;\n    margin-left: 0.2rem;\n    color: #464c5b;\n}\n.ivu-row-flex[data-v-58ac5fba] {\n  height: 100%;\n}\n.menu-label[data-v-58ac5fba] {\n  color: rgba(255, 255, 255, 0.36);\n  display: inline-block;\n  margin-top: 10px;\n  margin-left: 10px;\n  font-size: 18px;\n}\n.ivu-menu-dark.ivu-menu-vertical .ivu-menu-item[data-v-58ac5fba], .ivu-menu-dark.ivu-menu-vertical .ivu-menu-submenu-title[data-v-58ac5fba] {\n  font-size: 16px;\n}\n.content[data-v-58ac5fba] {\n  background: none repeat scroll 0 0 #f8f8f9;\n  border-color: #80848f;\n  position: absolute;\n  left: 240px;\n  right: 0;\n  top: 66px;\n  bottom: 3rem;\n  padding: 25px 40px 25px 40px;\n  box-sizing: border-box;\n  overflow-y: scroll;\n  margin: 0;\n}\n.ivu-menu-vertical .ivu-menu-submenu .ivu-menu-item[data-v-58ac5fba] {\n  padding-left: 43px;\n  padding-top: 5px;\n  padding-bottom: 5px;\n}\n.menu-content[data-v-58ac5fba]::-webkit-scrollbar {\n  display: none;\n}\n"],sourceRoot:""}])},300:function(t,a,e){var n=e(267);"string"==typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);e(169)("73992d85",n,!0)},333:function(t,a){t.exports={render:function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"layout"},[e("Row",{attrs:{type:"flex"}},[e("Col",{staticClass:"layout-menu-left",attrs:{span:"4"}},[e("Menu",{staticClass:"sideMenu ",staticStyle:{"font-size":"16px"},attrs:{theme:"dark",width:"auto","open-names":["1"],accordion:"",accordion:""},on:{"on-select":t.routeTo}},[e("div",{staticClass:"layout-logo-left",staticStyle:{color:"white","font-size":"25px",position:"fixed","z-index":"100"}},[e("span",{staticClass:"logo-head"},[t._v("特种设备使用登记系统")])]),t._v(" "),1==this.author_key?e("div",{staticClass:"menu-content",staticStyle:{position:"absolute",top:"60px",width:"100%"}},[e("label",{staticClass:"menu-label"},[t._v("申请类别")]),t._v(" "),e("Submenu",{attrs:{name:"1-1"}},[e("template",{staticStyle:{"font-size":"16px"},slot:"title"},[t._v("\n            首次申请\n          ")]),t._v(" "),e("div",{staticStyle:{overflow:"hidden"}},[e("MenuGroup",{attrs:{title:"按台(套)申请"}},[e("MenuItem",{attrs:{name:"newOrLast-1"}},[t._v("锅炉")]),t._v(" "),e("MenuItem",{attrs:{name:"newOrLast-2"}},[t._v("压力容器（气瓶除外）")]),t._v(" "),e("MenuItem",{attrs:{name:"newOrLast-3"}},[t._v("电梯")]),t._v(" "),e("MenuItem",{attrs:{name:"newOrLast-4"}},[t._v("起重机械")]),t._v(" "),e("MenuItem",{attrs:{name:"newOrLast-5"}},[t._v("客运索道")]),t._v(" "),e("MenuItem",{attrs:{name:"newOrLast-6"}},[t._v("大型游乐设施")]),t._v(" "),e("MenuItem",{attrs:{name:"newOrLast-7"}},[t._v("场 (厂)内专用机动车辆")])],1),t._v(" "),e("MenuGroup",{attrs:{title:"按单位申请"}},[e("MenuItem",{attrs:{name:"newOrLast-9"}},[t._v("气瓶(车用气瓶除外)")]),t._v(" "),e("MenuItem",{attrs:{name:"newOrLast-10"}},[t._v("工业管道")])],1),t._v(" "),e("MenuGroup",{attrs:{title:"车用气瓶"}},[e("MenuItem",{attrs:{name:"newOrLast-8"}},[t._v("车用气瓶")])],1)],1)],2),t._v(" "),e("Submenu",{attrs:{name:"2-1"}},[e("template",{slot:"title"},[t._v("\n            变更申请\n          ")]),t._v(" "),e("MenuItem",{attrs:{name:"transformChange"}},[t._v("改造变更")]),t._v(" "),e("MenuGroup",{attrs:{title:"移装变更"}},[e("MenuItem",{attrs:{name:"areaInChange"}},[t._v("登记机关行政区域内移装变更")]),t._v(" "),e("MenuItem",{attrs:{name:"areaAcrossChange"}},[t._v("跨登记机关行政区域移装变更")])],1),t._v(" "),e("MenuItem",{attrs:{name:"companyChange"}},[t._v("单位变更")]),t._v(" "),e("MenuItem",{attrs:{name:"nameChange"}},[t._v("更名变更")]),t._v(" "),e("MenuItem",{attrs:{name:"yearsChange"}},[t._v("达到设计使用年限变更")])],2),t._v(" "),e("Menu-item",{attrs:{name:"stopUseApp"}},[t._v("停用申请")]),t._v(" "),e("Menu-item",{attrs:{name:"devList-5"}},[t._v("停用后启用申请")]),t._v(" "),e("Menu-item",{attrs:{name:"disabledApp"}},[t._v("报废申请")]),t._v(" "),e("label",{staticClass:"menu-label"},[t._v("受理审查发证情况")]),t._v(" "),e("Menu-item",{attrs:{name:"applyerList"}},[t._v("已提交申请办理情况")]),t._v(" "),e("label",{staticClass:"menu-label"},[t._v("已有设备")]),t._v(" "),e("Menu-item",{attrs:{name:"devList"}},[t._v("已有设备列表")])],1):t._e(),t._v(" "),2==this.author_key?e("Menu-group",{attrs:{title:"受理机关"}},[e("label",{staticClass:"menu-label",staticStyle:{display:"block","padding-top":"10px"}},[t._v("受理机关")]),t._v(" "),e("Menu-item",{attrs:{name:"waitAccept"}},[t._v("未受理申请")]),t._v(" "),e("Menu-item",{attrs:{name:"accepted"}},[t._v("已受理申请")])],1):t._e(),t._v(" "),3==this.author_key?e("Menu-group",{attrs:{title:"审批机关"}},[e("label",{staticClass:"menu-label",staticStyle:{display:"block","padding-top":"10px"}},[t._v("审批机关")]),t._v(" "),e("Menu-item",{attrs:{name:"waitApproval"}},[t._v("未审批、发证申请")]),t._v(" "),e("Menu-item",{attrs:{name:"approvaled"}},[t._v("已审批、发证申请")]),t._v(" "),e("Menu-item",{attrs:{name:"appRegistDetail"}},[t._v("特种设备使用登记明细表")])],1):t._e(),t._v(" "),4==this.author_key?e("Menu-group",{attrs:{title:"监管机关"}},[e("Menu-item",{attrs:{name:"supervision"}},[t._v("已审批申请")])],1):t._e()],1)],1),t._v(" "),e("Col",{attrs:{span:"20"}},[e("div",{staticClass:"layout-header"},[e("v-header",{directives:[{name:"show",rawName:"v-show",value:t.headShow,expression:"headShow"}],attrs:{signinUp:"true"}})],1),t._v(" "),e("div",{staticClass:"layout-breadcrumb"}),t._v(" "),e("div",{staticClass:"layout-content"},[e("div",{staticClass:"layout-content-main"},[e("transition",{attrs:{name:"move",mode:"out-in"}},[e("keep-alive",[e("router-view")],1)],1)],1)]),t._v(" "),e("div",{staticClass:"layout-copy"},[t._v("\n      2011-2016 © TalkingData\n    ")])])],1)],1)},staticRenderFns:[]}}});
//# sourceMappingURL=13.d4bff4fd4fc708c77c28.js.map