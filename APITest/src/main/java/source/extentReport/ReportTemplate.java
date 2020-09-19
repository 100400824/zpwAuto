package source.extentReport;

import source.utls.OperationFile;

import java.util.Map;

public class ReportTemplate {

    public static final String filePath = System.getProperty("user.dir") + "\\APITest\\test-output\\";

    public static String tp1 = "<html><head>\n" +
            "\t<meta charset=\"utf-8\"> \n" +
            "\t<meta name=\"description\" content=\"\">\n" +
            "\t<meta name=\"robots\" content=\"noodp, noydir\">\n" +
            "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "\t<meta id=\"timeStampFormat\" name=\"timeStampFormat\" content=\"MMM d, yyyy hh:mm:ss a\">\n" +
            "\t\n" +
            "\t<link href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600\" rel=\"stylesheet\" type=\"text/css\">\n" +
            "\t<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n" +
            "\n" +
            "\t\t<link href=\"http://extentreports.com/resx/dist/css/extent.css\" type=\"text/css\" rel=\"stylesheet\">\n" +
            "\t\n" +
            "\t<title>自动化测试报告</title>\n" +
            "\n" +
            "\t<style type=\"text/css\">\n" +
            "\t\t.node.level-1  ul{ display:none;} .node.level-1.active ul{display:block;}\n" +
            "\t\t#parent-analysis {\n" +
            "\t\tleft: 364px!important;\n" +
            "\t}\t\t\n" +
            "\t</style>\n" +
            "\n" +
            "\t<script src=\"https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js\"></script>\n" +
            "</head>\n" +
            "\n" +
            "\t<body class=\"extent standard default hide-overflow \">\n" +
            "\t\t<div id=\"theme-selector\" alt=\"Click to toggle theme. To enable by default, use theme configuration.\" title=\"Click to toggle theme. To enable by default, use theme configuration.\">\n" +
            "\t\t\t<span><i class=\"material-icons\">desktop_windows</i></span>\n" +
            "\t\t</div>\n" +
            "\n" +
            "<nav>\n" +
            "\t<div class=\"nav-wrapper\">\n" +
            "\t\t<a href=\"#!\" class=\"brand-logo blue darken-3\">Extent</a>\n" +
            "\n" +
            "\t\t<!-- slideout menu -->\n" +
            "\t\t<ul id=\"slide-out\" class=\"side-nav fixed hide-on-med-and-down\">\n" +
            "\t\t\t<li class=\"waves-effect active\"><a href=\"#!\" view=\"test-view\" onclick=\"configureView(0);chartsView('test');\"><i class=\"material-icons\">dashboard</i></a></li>\n" +
            "\t\t\t\t\t\t<li class=\"waves-effect\"><a href=\"#!\" view=\"exception-view\" onclick=\"configureView(2)\"><i class=\"material-icons\">bug_report</i></a></li>\n" +
            "\t\t\t<li class=\"waves-effect\"><a href=\"#!\" onclick=\"configureView(-1);chartsView('dashboard');\" view=\"dashboard-view\"><i class=\"material-icons\">track_changes</i></a></li>\n" +
            "\t\t</ul>\n" +
            "\n" +
            "\t\t<!-- report name -->\n" +
            "\t\t<span class=\"report-name\">自动化测试报告</span>\n" +
            "\t\t\n" +
            "\t\t<!-- report headline -->\n" +
            "\t\t<span class=\"report-headline\"></span>\n" +
            "\n" +
            "\t\t<!-- nav-right -->\n" +
            "\t\t<ul id=\"nav-mobile\" class=\"right hide-on-med-and-down nav-right\">\n" +
            "\t\t\t<li>\n" +
            "                <a href=\"#!\">\n" +
            "                    <span class=\"label suite-start-time blue darken-3\">Sep 14, 2020 11:03:35 AM</span>\n" +
            "\t\t\t\t</a>\n" +
            "\t\t\t</li>\n" +
            "\t\t\t<li>\n" +
            "                <a href=\"#!\">\n" +
            "                    <span class=\"label blue darken-3\">v3.0.6</span>\n" +
            "\t\t\t\t</a>\n" +
            "\t\t\t</li>\n" +
            "\t\t</ul>\n" +
            "\t</div>\n" +
            "</nav>\n" +
            "\n" +
            "\t\t<!-- container -->\n" +
            "\t\t<div class=\"container\">\n" +
            "\n" +
            "<div id=\"test-view\" class=\"view\" >\n" +
            "\t\t\t\t\n" +
            "\t<section id=\"controls\" >\n" +
            "\t\t<div class=\"controls grey lighten-4\">\n" +
            "\t\t\t<!-- test toggle -->\n" +
            "\t\t\t<div class=\"chip transparent\" >\n" +
            "\t\t\t\t<a class=\"dropdown-button tests-toggle\" data-activates=\"tests-toggle\" data-constrainwidth=\"true\" data-beloworigin=\"true\" data-hover=\"true\" href=\"#\">\n" +
            "\t\t\t\t\t<i class=\"material-icons\">warning</i> Status\n" +
            "\t\t\t\t</a><ul id=\"tests-toggle\" class=\"dropdown-content\" style=\"width: 34px; position: absolute; top: 79px; left: 92px; opacity: 1; display: none;\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<li status=\"pass\"><a href=\"#!\">Pass <i class=\"material-icons green-text\">check_circle</i></a></li>\n" +
            "\t\t\t\t\t\t<li status=\"fail\"><a href=\"#!\">Fail <i class=\"material-icons red-text\">cancel</i></a></li>\n" +
            "\t\t\t\t\t<li class=\"divider\"></li>\n" +
            "\t\t\t\t\t<li status=\"clear\" clear=\"true\"><a href=\"#!\">Clear Filters <i class=\"material-icons\">clear</i></a></li>\n" +
            "\t\t\t\t</ul>\n" +
            "\t\t\t\t\n" +
            "\t\t\t</div>\n" +
            "\t\t\t<!-- test toggle -->\n" +
            "\n" +
            "\t\t\t<!-- category toggle -->\n" +
            "\t\t\t<!-- category toggle -->\n" +
            "\n" +
            "\t\t\t<!-- clear filters -->\n" +
            "\t\t\t<div class=\"chip transparent hide\" >\n" +
            "\t\t\t\t<a class=\"\" id=\"clear-filters\" alt=\"Clear Filters\" title=\"Clear Filters\">\n" +
            "\t\t\t\t\t<i class=\"material-icons\">close</i> Clear\n" +
            "\t\t\t\t</a>\n" +
            "\t\t\t</div>\n" +
            "\t\t\t<!-- clear filters -->\n" +
            "\n" +
            "\t\t\t<!-- enable dashboard -->\n" +
            "\t\t\t<div id=\"toggle-test-view-charts\" class=\"chip transparent\" >\n" +
            "\t\t\t\t<a class=\"pink-text\" id=\"enable-dashboard\" alt=\"Enable Dashboard\" title=\"Enable Dashboard\">\n" +
            "\t\t\t\t\t<i class=\"material-icons\">track_changes</i> Dashboard\n" +
            "\t\t\t\t</a>\n" +
            "\t\t\t</div>\n" +
            "\t\t\t<!-- enable dashboard -->\n" +
            "\n" +
            "\t\t\t<!-- search -->\n" +
            "\t\t\t<div class=\"chip transparent\" alt=\"Search Tests\" title=\"Search Tests\">\n" +
            "\t\t\t\t<a href=\"#\" class=\"search-div\">\n" +
            "\t\t\t\t\t<i class=\"material-icons\">search</i> Search\n" +
            "\t\t\t\t</a>\n" +
            "\n" +
            "\t\t\t\t<div class=\"input-field left hide\">\n" +
            "\t\t\t\t\t<input id=\"search-tests\" type=\"text\" class=\"validate browser-default\" placeholder=\"Search Tests...\">\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t\t\n" +
            "\t\t\t</div>\n" +
            "\t\t\t<!-- search -->\n" +
            "\t\t</div>\n" +
            "\t</section>\n" +
            "\n" +
            "\n" +
            "<div id=\"test-view-charts\" class=\"subview-full\" >\n" +
            "\t<div id=\"charts-row\" class=\"row nm-v nm-h\">\n" +
            "\t\t<div class=\"col s12 m6 l6 np-h\">\n" +
            "\t\t\t<div class=\"card-panel nm-v\">\n" +
            "\t\t\t\t<div class=\"left panel-name\">Tests</div>\n" +
            "\t\t\t<div class=\"chart-box\">\n" +
            "<!-- <canvas id=\"parent-analysis\" width=\"100\" height=\"80\" style=\"width: 100px; height: 80px;\"></canvas><ul class=\"doughnut-legend right\"><li><span style=\"background-color:#00af00\"></span>Pass</li><li><span style=\"background-color:#F7464A\"></span>Fail</li><li></li><li></li><li></li><li></li></ul> -->\n" +
            "\n" +
            "\n" +
            "<div id=\"parent-analysis\" style=\"width: 950px;height:100px;\"></div>\n" +
            "<script type=\"text/javascript\">\n" +
            "    // 基于准备好的dom，初始化echarts实例\n" +
            "\tvar myChart = echarts.init(document.getElementById('parent-analysis'));\n" +
            "   \n" +
            "    myChart.setOption({\n" +
            "        series : [\n" +
            "            {\n" +
            "                name: '访问来源',\n" +
            "                type: 'pie',    // 设置图表类型为饼图\n" +
            "                radius: '65%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。\n" +
            "                data:[          // 数据数组，name 为数据项名称，value 为数据项值\n" +
            "                   \n" +
            "                    {value:22, name:'测试失败：22'},\n" +
            "                    {value:144, name:'测试通过：144'},\n" +
            "              \n" +
            "                ]\n" +
            "            }\n" +
            "        ]\n" +
            "\t})\n" +
            "\twindow.onload = function(){\n" +
            "\tconsole.log(myChart,myChart._dom.children[0].getElementsByTagName('canvas')[0])\n" +
            "\tmyChart._dom.children[0].getElementsByTagName('canvas')[0].style.left=\"270px\"\n" +
            "\t\n" +
            "\t\n" +
            "\n" +
            "}\n" +
            "</script> \n" +
            "\t\t\t</div>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<div class=\"block text-small\" style = \"width:200px;\">\n" +
            "\t\t\t\t\t<span class=\"tooltipped\" data-position=\"top\" data-tooltip=\"50%\" data-tooltip-id=\"2453041c-b251-7979-7a3a-4d8f0a215761\"><span class=\"strong\">144</span> test(s) passed</span>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t\t<div class=\"block text-small\" style = \"width:200px;\">\n" +
            "\t\t\t\t\t<span class=\"strong tooltipped\" data-position=\"top\" data-tooltip=\"50%\" data-tooltip-id=\"026a6157-be85-26f3-4daa-d3a0cc65ab73\">22</span> test(s) failed, <span class=\"strong tooltipped\" data-position=\"top\" data-tooltip=\"0%\" data-tooltip-id=\"b2b70954-4299-e4aa-9a56-f975b3559eb4\">0</span> others\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t</div>\n" +
            "\t\t</div>\n" +
            "\t\t\n" +
            "\t\t<div class=\"col s12 m6 l6 np-h\">\n" +
            "\t\t\t<div class=\"card-panel nm-v\">\n" +
            "\t\t\t\t<div class=\"left panel-name\">Steps</div>\n" +
            "\t\t\t\t<div class=\"chart-box\">\n" +
            "\t\t\t\t\t<canvas id=\"parent-analysis\"  width=\"100\" height=\"80\" style=\"width: 100px; height: 80px;left:364px!important;\"></canvas><ul class=\"doughnut-legend right\"><li><span style=\"background-color:#00af00\"></span>Pass</li><li><span style=\"background-color:#F7464A\"></span>Fail</li><li></li><li></li><li></li><li></li><li></li></ul>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t\t<div class=\"block text-small\">\n" +
            "\t\t\t\t\t<span class=\"tooltipped\" data-position=\"top\" data-tooltip=\"50%\" data-tooltip-id=\"8affe5e5-3bc6-f594-1714-aca929343d65\"><span class=\"strong\">0</span> step(s) passed</span>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t\t<div class=\"block text-small\">\n" +
            "\t\t\t\t\t<span class=\"strong tooltipped\" data-position=\"top\" data-tooltip=\"50%\" data-tooltip-id=\"ed16fb44-6f75-e28b-1bdc-8790efc63772\">0</span> step(s) failed, <span class=\"strong tooltipped\" data-position=\"top\" data-tooltip=\"0%\" data-tooltip-id=\"07d06ff5-cf7a-0620-2815-cd1bc8114533\">0</span> others\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t</div>\n" +
            "\t\t</div>\n" +
            "\t\t\n" +
            "\t</div>\n" +
            "</div>\n" +
            "\n" +
            "\t<div class=\"subview-left left\" style=\"resize: horizontal; height: 267px;\">\n" +
            "\t\t\n" +
            "\t\t<div class=\"view-summary\" style=\"height: 249px;\">\n" +
            "\t\t\t<h5>Tests</h5>\n" +
            "\t\t\t<ul id=\"test-collection\" class=\"test-collection\">\n";

    public static String allListTemplateFail =
            "\t\t\t\t<li class=\"test displayed  fail active\" status=\"fail\" bdd=\"false\" test-id=\"reportTemplateId\">\n" +
                    "\t\t\t\t\t<div class=\"test-heading\">\n" +
                    "\t\t\t\t\t\t<span class=\"test-name\">reportTemplateRequestName</span>\n" +
                    "\t\t\t\t\t\t<span class=\"test-time\">reportTemplateStartTime</span>\n" +
                    "\t\t\t\t\t\t<span class=\"test-status right fail\">fail</span>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t<div class=\"test-content hide\">\n" +
                    "<div class=\"test-time-info\">\n" +
                    "\t<span class=\"label start-time\">reportTemplateStartTime</span>\n" +
                    "\t<span class=\"label end-time\">reportTemplateEndTime</span>\n" +
                    "\t<span class=\"label time-taken grey lighten-1 white-text\">reportTemplateTakenTime</span>\n" +
                    "</div>\n" +
                    "\t<div class=\"test-steps\">\n" +
                    "\t\t<table class=\"bordered table-results\">\n" +
                    "\t\t\t<thead>\n" +
                    "\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t<th>Status</th>\n" +
                    "\t\t\t\t\t<th>Timestamp</th>\n" +
                    "\t\t\t\t\t<th>Details</th>\n" +
                    "\t\t\t\t</tr>\n" +
                    "\t\t\t</thead>\n" +
                    "\t\t\t<tbody>\n" +
                    "\t\t\t\t<tr class=\"log\" status=\"fail\">\n" +
                    "\t\t\t\t\t<td class=\"status fail\" title=\"fail\" alt=\"fail\"><i class=\"material-icons\">cancel</i></td>\n" +
                    "\t\t\t\t\t<td class=\"timestamp\">reportTemplateStartTime</td>\n" +
                    "\t\t\t\t\t<td class=\"step-details\"><pre>" + "reportTemplateRequestDetail" +
                    "</pre></td>\n" +
                    "\t\t\t\t</tr>\n" +
                    "\t\t\t</tbody>\n" +
                    "\t\t</table>\n" +
                    "\t</div>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t</li>\n";

    public static String tp2 = "\t\t\t\t<li class=\"test displayed  pass\" status=\"pass\" bdd=\"false\" test-id=\"6\">\n" +
            "\t\t\t\t\t<div class=\"test-heading\">\n" +
            "\t\t\t\t\t\t<span class=\"test-name\">test2</span>\n" +
            "\t\t\t\t\t\t<span class=\"test-time\">Sep 14, 2020 11:03:35 AM</span>\n" +
            "\t\t\t\t\t\t<span class=\"test-status right pass\">pass</span>\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t<div class=\"test-content hide\">\n" +
            "<div class=\"test-time-info\">\n" +
            "\t<span class=\"label start-time\">Sep 14, 2020 11:03:35 AM</span>\n" +
            "\t<span class=\"label end-time\">Sep 14, 2020 11:03:35 AM</span>\n" +
            "\t<span class=\"label time-taken grey lighten-1 white-text\">0h 0m 0s+1ms</span>\n" +
            "</div>\n" +
            "\t<div class=\"test-steps\">\n" +
            "\t\t<table class=\"bordered table-results\">\n" +
            "\t\t\t<thead>\n" +
            "\t\t\t\t<tr>\n" +
            "\t\t\t\t\t<th>Status</th>\n" +
            "\t\t\t\t\t<th>Timestamp</th>\n" +
            "\t\t\t\t\t<th>Details</th>\n" +
            "\t\t\t\t</tr>\n" +
            "\t\t\t</thead>\n" +
            "\t\t\t<tbody>\n" +
            "\t\t\t\t<tr class=\"log\" status=\"pass\">\n" +
            "\t\t\t\t\t<td class=\"status pass\" title=\"pass\" alt=\"pass\"><i class=\"material-icons\">check_circle</i></td>\n" +
            "\t\t\t\t\t<td class=\"timestamp\">11:03:35 AM</td>\n" +
            "\t\t\t\t\t<td class=\"step-details\">Test passed</td>\n" +
            "\t\t\t\t</tr>\n" +
            "\t\t\t</tbody>\n" +
            "\t\t</table>\n" +
            "\t</div>\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t\t\t\n" +
            "\t\t\t</ul>\n" +
            "\t\t</div>\n" +
            "\t</div>\n" +
            "\t<!-- subview left -->\n" +
            "\n" +
            "\t<div class=\"subview-right left\" style=\"height: 267px; width: 1338px;\">\n" +
            "\t\t<div class=\"view-summary\" style=\"height: 249px;\">\n" +
            "\t\t\t<h5 class=\"test-name\">test1</h5>\n" +
            "\n" +
            "\t\t\t<div id=\"step-filters\" class=\"right\">\n" +
            "\t\t\t\t<span class=\"blue-text\" status=\"info\" alt=\"info\" title=\"info\"><i class=\"material-icons\">info_outline</i></span>\n" +
            "\t\t\t\t<span class=\"green-text\" status=\"pass\" alt=\"pass\" title=\"pass\"><i class=\"material-icons\">check_circle</i></span>\n" +
            "\t\t\t\t<span class=\"red-text\" status=\"fail\" alt=\"fail\" title=\"fail\"><i class=\"material-icons\">cancel</i></span>\n" +
            "\t\t\t\t<span class=\"red-text text-darken-4\" status=\"fatal\" alt=\"fatal\" title=\"fatal\"><i class=\"material-icons\">cancel</i></span>\n" +
            "\t\t\t\t<span class=\"pink-text text-lighten-1\" status=\"error\" alt=\"error\" title=\"error\"><i class=\"material-icons\">error</i></span>\n" +
            "\t\t\t\t<span class=\"orange-text\" alt=\"warning\" status=\"warning\" title=\"warning\"><i class=\"material-icons\">warning</i></span>\n" +
            "\t\t\t\t<span class=\"teal-text\" status=\"skip\" alt=\"skip\" title=\"skip\"><i class=\"material-icons\">redo</i></span>\n" +
            "\t\t\t\t<span status=\"clear\" alt=\"Clear filters\" title=\"Clear filters\"><i class=\"material-icons\">clear</i></span>\n" +
            "\t\t\t</div>\n" +
            "\t\t<div class=\"test-content\">\n" +
            "<div class=\"test-time-info\">\n" +
            "\t<span class=\"label start-time\">Sep 14, 2020 11:03:35 AM</span>\n" +
            "\t<span class=\"label end-time\">Sep 14, 2020 11:03:35 AM</span>\n" +
            "\t<span class=\"label time-taken grey lighten-1 white-text\">0h 0m 0s+10ms</span>\n" +
            "</div>\n" +
            "\t<div class=\"test-steps\">\n" +
            "\t\t<table class=\"bordered table-results\">\n" +
            "\t\t\t<thead>\n" +
            "\t\t\t\t<tr>\n" +
            "\t\t\t\t\t<th>Status</th>\n" +
            "\t\t\t\t\t<th>Timestamp</th>\n" +
            "\t\t\t\t\t<th>Details</th>\n" +
            "\t\t\t\t</tr>\n" +
            "\t\t\t</thead>\n" +
            "\t\t\t<tbody>\n" +
            "\t\t\t\t<tr class=\"log\" status=\"fail\">\n" +
            "\t\t\t\t\t<td class=\"status fail\" title=\"fail\" alt=\"fail\"><i class=\"material-icons\">cancel</i></td>\n" +
            "\t\t\t\t\t<td class=\"timestamp\">11:03:35 AM</td>\n" +
            "\t\t\t\t\t<td class=\"step-details\"><pre>java.lang.AssertionError: expected [2] but found [1]\n" +
            "\tat org.testng.Assert.fail(Assert.java:94)\n" +
            "\tat org.testng.Assert.failNotEquals(Assert.java:513)\n" +
            "\tat org.testng.Assert.assertEqualsImpl(Assert.java:135)\n" +
            "\tat org.testng.Assert.assertEquals(Assert.java:116)\n" +
            "\tat org.testng.Assert.assertEquals(Assert.java:389)\n" +
            "\tat org.testng.Assert.assertEquals(Assert.java:399)\n" +
            "\tat source.extentReport.extentreportsDemo.test1(extentreportsDemo.java:15)\n" +
            "\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n" +
            "\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\n" +
            "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\n" +
            "\tat java.lang.reflect.Method.invoke(Unknown Source)\n" +
            "\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:104)\n" +
            "\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:645)\n" +
            "\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:851)\n" +
            "\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1177)\n" +
            "\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:129)\n" +
            "\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:112)\n" +
            "\tat org.testng.TestRunner.privateRun(TestRunner.java:756)\n" +
            "\tat org.testng.TestRunner.run(TestRunner.java:610)\n" +
            "\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:387)\n" +
            "\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:382)\n" +
            "\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:340)\n" +
            "\tat org.testng.SuiteRunner.run(SuiteRunner.java:289)\n" +
            "\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)\n" +
            "\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)\n" +
            "\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1293)\n" +
            "\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1218)\n" +
            "\tat org.testng.TestNG.runSuites(TestNG.java:1133)\n" +
            "\tat org.testng.TestNG.run(TestNG.java:1104)\n" +
            "\tat org.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:72)\n" +
            "\tat org.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:123)\n" +
            "</pre></td>\n" +
            "\t\t\t\t</tr>\n" +
            "\t\t\t</tbody>\n" +
            "\t\t</table>\n" +
            "\t</div>\n" +
            "\t\t\t\t\t</div></div>\n" +
            "\t</div>\n" +
            "\t<!-- subview right -->\n" +
            "\n" +
            "</div>\n" +
            "<!-- test view -->\n" +
            "<!-- category view -->\n" +
            "<div id=\"exception-view\" class=\"view hide\">\n" +
            "\n" +
            "    <section id=\"controls\">\n" +
            "        <div class=\"controls grey lighten-4\">\n" +
            "            <!-- search -->\n" +
            "            <div class=\"chip transparent\" alt=\"Search Tests\" title=\"Search Tests\">\n" +
            "                <a href=\"#\" class=\"search-div\">\n" +
            "                    <i class=\"material-icons\">search</i> Search\n" +
            "                </a>\n" +
            "\n" +
            "                <div class=\"input-field left hide\">\n" +
            "                    <input id=\"search-tests\" type=\"text\" class=\"validate browser-default\" placeholder=\"Search Tests...\">\n" +
            "                </div>\n" +
            "\n" +
            "            </div>\n" +
            "            <!-- search -->\n" +
            "        </div>\n" +
            "    </section>\n" +
            "\n" +
            "    <div class=\"subview-left left\" style=\"resize: horizontal;\">\n" +
            "\n" +
            "        <div class=\"view-summary\">\n" +
            "            <h5>Exceptions</h5>\n" +
            "                <ul id=\"exception-collection\" class=\"exception-collection\">\n" +
            "\n" +
            "                        <li class=\"exception displayed active\">\n" +
            "                            <div class=\"exception-heading\">\n" +
            "                                <span class=\"exception-name\">java.lang.AssertionError</span>\n" +
            "                                <span class=\"exception-count right\"><span class=\"label red lighten-1 white-text\">1</span></span>\n" +
            "                            </div>\n" +
            "                            <div class=\"exception-content hide\">\n" +
            "                                <div class=\"exception-tests\">\n" +
            "                                    <table class=\"bordered table-results\">\n" +
            "                                        <thead>\n" +
            "                                        <tr>\n" +
            "                                            <th>Timestamp</th>\n" +
            "                                            <th>TestName</th>\n" +
            "                                            <th>Status</th>\n" +
            "                                        </tr>\n" +
            "                                        </thead>\n" +
            "                                        <tbody>\n" +
            "                                                    <tr>\n" +
            "                                                        <td>Sep 14, 2020 11:03:35 AM</td>\n" +
            "                                                        <td class=\"linked\" test-id=\"5\">test1</td>\n" +
            "                                                        <td><pre><pre>java.lang.AssertionError: expected [2] but found [1]\n" +
            "\tat org.testng.Assert.fail(Assert.java:94)\n" +
            "\tat org.testng.Assert.failNotEquals(Assert.java:513)\n" +
            "\tat org.testng.Assert.assertEqualsImpl(Assert.java:135)\n" +
            "\tat org.testng.Assert.assertEquals(Assert.java:116)\n" +
            "\tat org.testng.Assert.assertEquals(Assert.java:389)\n" +
            "\tat org.testng.Assert.assertEquals(Assert.java:399)\n" +
            "\tat source.extentReport.extentreportsDemo.test1(extentreportsDemo.java:15)\n" +
            "\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n" +
            "\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\n" +
            "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\n" +
            "\tat java.lang.reflect.Method.invoke(Unknown Source)\n" +
            "\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:104)\n" +
            "\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:645)\n" +
            "\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:851)\n" +
            "\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1177)\n" +
            "\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:129)\n" +
            "\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:112)\n" +
            "\tat org.testng.TestRunner.privateRun(TestRunner.java:756)\n" +
            "\tat org.testng.TestRunner.run(TestRunner.java:610)\n" +
            "\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:387)\n" +
            "\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:382)\n" +
            "\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:340)\n" +
            "\tat org.testng.SuiteRunner.run(SuiteRunner.java:289)\n" +
            "\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)\n" +
            "\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)\n" +
            "\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1293)\n" +
            "\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1218)\n" +
            "\tat org.testng.TestNG.runSuites(TestNG.java:1133)\n" +
            "\tat org.testng.TestNG.run(TestNG.java:1104)\n" +
            "\tat org.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:72)\n" +
            "\tat org.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:123)\n" +
            "</pre></pre></td>\n" +
            "                                                    </tr>\n" +
            "                                        </tbody>\n" +
            "                                    </table>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                        </li>\n" +
            "\n" +
            "                        <li class=\"exception displayed active\">\n" +
            "                            <div class=\"exception-heading\">\n" +
            "                                <span class=\"exception-name\">java.lang.AssertionError</span>\n" +
            "                                <span class=\"exception-count right\"><span class=\"label red lighten-1 white-text\">1</span></span>\n" +
            "                            </div>\n" +
            "                            <div class=\"exception-content hide\">\n" +
            "                                <div class=\"exception-tests\">\n" +
            "                                    <table class=\"bordered table-results\">\n" +
            "                                        <thead>\n" +
            "                                        <tr>\n" +
            "                                            <th>Timestamp</th>\n" +
            "                                            <th>TestName</th>\n" +
            "                                            <th>Status</th>\n" +
            "                                        </tr>\n" +
            "                                        </thead>\n" +
            "                                        <tbody>\n" +
            "                                                    <tr>\n" +
            "                                                        <td>Sep 14, 2020 11:03:35 AM</td>\n" +
            "                                                        <td class=\"linked\" test-id=\"8\">test2</td>\n" +
            "                                                        <td><pre><pre>java.lang.AssertionError: expected [2222] but found [1]\n" +
            "\tat org.testng.Assert.fail(Assert.java:94)\n" +
            "\tat org.testng.Assert.failNotEquals(Assert.java:513)\n" +
            "\tat org.testng.Assert.assertEqualsImpl(Assert.java:135)\n" +
            "\tat org.testng.Assert.assertEquals(Assert.java:116)\n" +
            "\tat org.testng.Assert.assertEquals(Assert.java:389)\n" +
            "\tat org.testng.Assert.assertEquals(Assert.java:399)\n" +
            "\tat source.extentReport.extentreportsDemo.test1(extentreportsDemo.java:15)\n" +
            "\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n" +
            "\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\n" +
            "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\n" +
            "\tat java.lang.reflect.Method.invoke(Unknown Source)\n" +
            "\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:104)\n" +
            "\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:645)\n" +
            "\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:851)\n" +
            "\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1177)\n" +
            "\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:129)\n" +
            "\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:112)\n" +
            "\tat org.testng.TestRunner.privateRun(TestRunner.java:756)\n" +
            "\tat org.testng.TestRunner.run(TestRunner.java:610)\n" +
            "\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:387)\n" +
            "\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:382)\n" +
            "\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:340)\n" +
            "\tat org.testng.SuiteRunner.run(SuiteRunner.java:289)\n" +
            "\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)\n" +
            "\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)\n" +
            "\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1293)\n" +
            "\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1218)\n" +
            "\tat org.testng.TestNG.runSuites(TestNG.java:1133)\n" +
            "\tat org.testng.TestNG.run(TestNG.java:1104)\n" +
            "\tat org.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:72)\n" +
            "\tat org.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:123)\n" +
            "</pre></pre></td>\n" +
            "                                                    </tr>\n" +
            "                                        </tbody>\n" +
            "                                    </table>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                        </li>\n" +
            "                </ul>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "\n" +
            "    <div class=\"subview-right left\">\n" +
            "        <div class=\"view-summary\">\n" +
            "            <h5 class=\"exception-name\">java.lang.AssertionError</h5>\n" +
            "        <div class=\"exception-content\">\n" +
            "                                <div class=\"exception-tests\">\n" +
            "                                    <table class=\"bordered table-results\">\n" +
            "                                        <thead>\n" +
            "                                        <tr>\n" +
            "                                            <th>Timestamp</th>\n" +
            "                                            <th>TestName</th>\n" +
            "                                            <th>Status</th>\n" +
            "                                        </tr>\n" +
            "                                        </thead>\n" +
            "                                        <tbody>\n" +
            "                                                    <tr>\n" +
            "                                                        <td>Sep 14, 2020 11:03:35 AM</td>\n" +
            "                                                        <td class=\"linked\" test-id=\"5\">test1</td>\n" +
            "                                                        <td><pre><pre>java.lang.AssertionError: expected [2] but found [1]\n" +
            "\tat org.testng.Assert.fail(Assert.java:94)\n" +
            "\tat org.testng.Assert.failNotEquals(Assert.java:513)\n" +
            "\tat org.testng.Assert.assertEqualsImpl(Assert.java:135)\n" +
            "\tat org.testng.Assert.assertEquals(Assert.java:116)\n" +
            "\tat org.testng.Assert.assertEquals(Assert.java:389)\n" +
            "\tat org.testng.Assert.assertEquals(Assert.java:399)\n" +
            "\tat source.extentReport.extentreportsDemo.test1(extentreportsDemo.java:15)\n" +
            "\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n" +
            "\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\n" +
            "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\n" +
            "\tat java.lang.reflect.Method.invoke(Unknown Source)\n" +
            "\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:104)\n" +
            "\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:645)\n" +
            "\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:851)\n" +
            "\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1177)\n" +
            "\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:129)\n" +
            "\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:112)\n" +
            "\tat org.testng.TestRunner.privateRun(TestRunner.java:756)\n" +
            "\tat org.testng.TestRunner.run(TestRunner.java:610)\n" +
            "\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:387)\n" +
            "\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:382)\n" +
            "\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:340)\n" +
            "\tat org.testng.SuiteRunner.run(SuiteRunner.java:289)\n" +
            "\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)\n" +
            "\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)\n" +
            "\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1293)\n" +
            "\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1218)\n" +
            "\tat org.testng.TestNG.runSuites(TestNG.java:1133)\n" +
            "\tat org.testng.TestNG.run(TestNG.java:1104)\n" +
            "\tat org.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:72)\n" +
            "\tat org.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:123)\n" +
            "</pre></pre></td>\n" +
            "                                                    </tr>\n" +
            "                                        </tbody>\n" +
            "                                    </table>\n" +
            "                                </div>\n" +
            "                            </div></div>\n" +
            "    </div>\n" +
            "    <div class=\"subview-right left\">\n" +
            "        <div class=\"view-summary\">\n" +
            "            <h5 class=\"exception-name\">java.lang.AssertionError</h5>\n" +
            "        <div class=\"exception-content\">\n" +
            "                                <div class=\"exception-tests\">\n" +
            "                                    <table class=\"bordered table-results\">\n" +
            "                                        <thead>\n" +
            "                                        <tr>\n" +
            "                                            <th>Timestamp</th>\n" +
            "                                            <th>TestName</th>\n" +
            "                                            <th>Status</th>\n" +
            "                                        </tr>\n" +
            "                                        </thead>\n" +
            "                                        <tbody>\n" +
            "                                                    <tr>\n" +
            "                                                        <td>Sep 14, 2020 11:03:35 AM</td>\n" +
            "                                                        <td class=\"linked\" test-id=\"8\">test2</td>\n" +
            "                                                        <td><pre><pre>java.lang.AssertionError: expected [2222] but found [1]\n" +
            "\tat org.testng.Assert.fail(Assert.java:94)\n" +
            "\tat org.testng.Assert.failNotEquals(Assert.java:513)\n" +
            "\tat org.testng.Assert.assertEqualsImpl(Assert.java:135)\n" +
            "\tat org.testng.Assert.assertEquals(Assert.java:116)\n" +
            "\tat org.testng.Assert.assertEquals(Assert.java:389)\n" +
            "\tat org.testng.Assert.assertEquals(Assert.java:399)\n" +
            "\tat source.extentReport.extentreportsDemo.test1(extentreportsDemo.java:15)\n" +
            "\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n" +
            "\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\n" +
            "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\n" +
            "\tat java.lang.reflect.Method.invoke(Unknown Source)\n" +
            "\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:104)\n" +
            "\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:645)\n" +
            "\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:851)\n" +
            "\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1177)\n" +
            "\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:129)\n" +
            "\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:112)\n" +
            "\tat org.testng.TestRunner.privateRun(TestRunner.java:756)\n" +
            "\tat org.testng.TestRunner.run(TestRunner.java:610)\n" +
            "\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:387)\n" +
            "\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:382)\n" +
            "\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:340)\n" +
            "\tat org.testng.SuiteRunner.run(SuiteRunner.java:289)\n" +
            "\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)\n" +
            "\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)\n" +
            "\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1293)\n" +
            "\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1218)\n" +
            "\tat org.testng.TestNG.runSuites(TestNG.java:1133)\n" +
            "\tat org.testng.TestNG.run(TestNG.java:1104)\n" +
            "\tat org.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:72)\n" +
            "\tat org.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:123)\n" +
            "</pre></pre></td>\n" +
            "                                                    </tr>\n" +
            "                                        </tbody>\n" +
            "                                    </table>\n" +
            "                                </div>\n" +
            "                            </div></div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "<!-- exception view -->\n" +
            "<div id=\"dashboard-view\" class=\"view hide\">\n" +
            "\t<div class=\"card-panel transparent np-v\">\n" +
            "\t\t<h5>Dashboard</h5>\n" +
            "\n" +
            "\t\t<div class=\"row\">\n" +
            "\t\t\t<div class=\"col s2\">\n" +
            "\t\t\t\t<div class=\"card-panel r\">\n" +
            "\t\t\t\t\tTests\n" +
            "\t\t\t\t\t<div class=\"panel-lead\">2</div>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t</div>\n" +
            "\t\t\t<div class=\"col s2\">\n" +
            "\t\t\t\t<div class=\"card-panel r\">\n" +
            "\t\t\t\t\tSteps\n" +
            "\t\t\t\t\t<div class=\"panel-lead\">2</div>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t</div>\n" +
            "\t\t\t<div class=\"col s2\">\n" +
            "\t\t\t\t<div class=\"card-panel r\">\n" +
            "\t\t\t\t\tStart\n" +
            "\t\t\t\t\t<div class=\"panel-lead\">Sep 14, 2020 11:03:35 AM</div>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t</div>\n" +
            "\t\t\t<div class=\"col s2\">\n" +
            "\t\t\t\t<div class=\"card-panel r\">\n" +
            "\t\t\t \t\tEnd\n" +
            "\t\t\t \t\t<div class=\"panel-lead\">Sep 14, 2020 11:03:35 AM</div>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t</div>\n" +
            "\t\t\t<div class=\"col s2\">\n" +
            "\t\t\t\t<div class=\"card-panel r\">\n" +
            "\t\t\t\t\tTime Taken\n" +
            "\t\t\t\t\t<div class=\"panel-lead\">10ms</div>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t</div>\n" +
            "\t\t</div>\n" +
            "\t</div>\n" +
            "</div>\n" +
            "<!-- dashboard view -->\n" +
            "<!-- testrunner-logs view -->\n" +
            "\t\t</div>\n" +
            "\t\t<!-- container -->\n" +
            "\n" +
            "\t\t<script>\n" +
            "\t\t\tvar statusGroup = {\n" +
            "\t\t\t\tpassParent: 1,\n" +
            "\t\t\t\tfailParent: 1,\n" +
            "\t\t\t\tfatalParent: 0,\n" +
            "\t\t\t\terrorParent: 0,\n" +
            "\t\t\t\twarningParent: 0,\n" +
            "\t\t\t\tskipParent: 0,\n" +
            "\t\t\t\texceptionsParent: 1,\n" +
            "\t\t\t\t\n" +
            "\t\t\t\tpassChild: 1,\n" +
            "\t\t\t\tfailChild: 1,\n" +
            "\t\t\t\tfatalChild: 0,\n" +
            "\t\t\t\terrorChild: 0,\n" +
            "\t\t\t\twarningChild: 0,\n" +
            "\t\t\t\tskipChild: 0,\n" +
            "\t\t\t\tinfoChild: 0,\n" +
            "\t\t\t\texceptionsChild: 1,\n" +
            "\t\t\t\t\n" +
            "\t\t\t\tpassGrandChild: 0,\n" +
            "\t\t\t\tfailGrandChild: 0,\n" +
            "\t\t\t\tfatalGrandChild: 0,\n" +
            "\t\t\t\terrorGrandChild: 0,\n" +
            "\t\t\t\twarningGrandChild: 0,\n" +
            "\t\t\t\tskipGrandChild: 0,\n" +
            "\t\t\t\tinfoGrandChild: 0,\n" +
            "\t\t\t\texceptionsGrandChild: 0,\n" +
            "\t\t\t};\n" +
            "\t\t</script>\n" +
            "\t\t\n" +
            "\t\t\t<script src=\"http://extentreports.com/resx/dist/js/extent.js\" type=\"text/javascript\"></script>\n" +
            "\t\t\n" +
            "\t\t\n" +
            "\t\n" +
            "\t\n" +
            "\n" +
            "<div class=\"material-tooltip\" id=\"2453041c-b251-7979-7a3a-4d8f0a215761\"><span>50%</span><div class=\"backdrop\" style=\"top: 0px; left: 0px;\"></div></div><div class=\"material-tooltip\" id=\"026a6157-be85-26f3-4daa-d3a0cc65ab73\"><span>50%</span><div class=\"backdrop\" style=\"top: 0px; left: 0px;\"></div></div><div class=\"material-tooltip\" id=\"b2b70954-4299-e4aa-9a56-f975b3559eb4\"><span>0%</span><div class=\"backdrop\" style=\"top: 0px; left: 0px;\"></div></div><div class=\"material-tooltip\" id=\"8affe5e5-3bc6-f594-1714-aca929343d65\"><span>50%</span><div class=\"backdrop\" style=\"top: 0px; left: 0px;\"></div></div><div class=\"material-tooltip\" id=\"ed16fb44-6f75-e28b-1bdc-8790efc63772\"><span>50%</span><div class=\"backdrop\" style=\"top: 0px; left: 0px;\"></div></div><div class=\"material-tooltip\" id=\"07d06ff5-cf7a-0620-2815-cd1bc8114533\"><span>0%</span><div class=\"backdrop\" style=\"top: 0px; left: 0px;\"></div></div><div class=\"hiddendiv common\"></div></body></html>";

    public static void main(String[] args) throws Exception {
//        OperationFile.write(filePath + "APITest.html", getTemplate());
    }

    public static String getTemplate(Map<String, Object> caseMsgMap) {
        String reportHtml;
        String caseResultMsg = allListTemplateFail;
        caseResultMsg = caseResultMsg.replace("reportTemplateId", caseMsgMap.get("api_id").toString() + caseMsgMap.get("cases_id").toString());
        caseResultMsg = caseResultMsg.replace("reportTemplateRequestName", caseMsgMap.get("cases_id") + "." + caseMsgMap.get("api_description") + ":" + caseMsgMap.get("cases_description").toString());
        caseResultMsg = caseResultMsg.replace("reportTemplateStartTime", caseMsgMap.get("reportTemplateStartTime").toString());
        caseResultMsg = caseResultMsg.replace("reportTemplateEndTime", caseMsgMap.get("reportTemplateEndTime").toString());
        caseResultMsg = caseResultMsg.replace("reportTemplateTakenTime", caseMsgMap.get("reportTemplateTakenTime").toString());
        caseResultMsg = caseResultMsg.replace("reportTemplateRequestDetail", ReportTemplate.getRequestDetail(caseMsgMap));
        reportHtml = caseResultMsg;
        return reportHtml;
    }

    public static String getRequestDetail(Map<String, Object> caseMsgMap) {

        return "执行详情：\n" +
                "模拟场景：" + caseMsgMap.get("cases_description") + "\n" +
                "接口地址：" + caseMsgMap.get("api_url") + "\n" +
                "请求参数：" + caseMsgMap.get("requestParamMap") + "\n" +
                "期望响应结果： " + caseMsgMap.get("cases_verifytype") + " " + caseMsgMap.get("cases_expect") + "\n" +
                "实际响应结果： " + caseMsgMap.get("resultActual");
    }
}
