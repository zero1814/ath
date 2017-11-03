<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="commons/header.jsp" %>
<div class="wrapper wrapper-content">
	<div class="row">
		<!--
          	作者：zero1814@126.com
          	时间：2017-10-30
          	描述：订单完成率
          	-->
		<div class="col-sm-8" style="padding-right:0;">
			<div class="ibox float-e-margins">
				<div class="ibox-content" style="border-top:none;">
					<div id="order" style="height:217px;">
					</div>
				</div>
			</div>
			<div class="ibox float-e-margins">
				<div class="ibox-content" style="border-top:none;">
					<div id="user" style="height:217px;">
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-4 col-lg-push-4">
			<div class="ibox float-e-margins">
				<div class="" id="ibox-content">
					<div id="vertical-timeline" class="vertical-container light-timeline">
						<div class="vertical-timeline-block">
							<div class="vertical-timeline-icon navy-bg">
								<i class="fa fa-briefcase"></i>
							</div>

							<div class="vertical-timeline-content">
								<h2>会议</h2>
								<p>上一年的销售业绩发布会。总结产品营销和销售趋势及销售的现状。
								</p>
								<a href="#" class="btn btn-sm btn-primary"> 更多信息</a>
								<span class="vertical-date">
                                      今天 <br>
                                      <small>2月3日</small>
                                  </span>
							</div>
						</div>

						<div class="vertical-timeline-block">
							<div class="vertical-timeline-icon blue-bg">
								<i class="fa fa-file-text"></i>
							</div>

							<div class="vertical-timeline-content">
								<h2>给张三发送文档</h2>
								<p>发送上年度《销售业绩报告》</p>
								<a href="#" class="btn btn-sm btn-success"> 下载文档 </a>
								<span class="vertical-date">
                                      今天 <br>
                                      <small>2月3日</small>
                                  </span>
							</div>
						</div>

						<div class="vertical-timeline-block">
							<div class="vertical-timeline-icon lazur-bg">
								<i class="fa fa-coffee"></i>
							</div>

							<div class="vertical-timeline-content">
								<h2>喝咖啡休息</h2>
								<p>喝咖啡啦，啦啦啦~~</p>
								<a href="#" class="btn btn-sm btn-info">更多</a>
								<span class="vertical-date"> 昨天 <br><small>2月2日</small></span>
							</div>
						</div>

						<div class="vertical-timeline-block">
							<div class="vertical-timeline-icon yellow-bg">
								<i class="fa fa-phone"></i>
							</div>

							<div class="vertical-timeline-content">
								<h2>给李四打电话</h2>
								<p>给李四打电话分配本月工作任务</p>
								<span class="vertical-date">昨天 <br><small>2月2日</small></span>
							</div>
						</div>

						<div class="vertical-timeline-block">
							<div class="vertical-timeline-icon lazur-bg">
								<i class="fa fa-user-md"></i>
							</div>

							<div class="vertical-timeline-content">
								<h2>公司年会</h2>
								<p>发年终奖啦，啦啦啦~~</p>
								<span class="vertical-date">前天 <br><small>2月1日</small></span>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
<script src="assets/plugins/echarts/3.7.2/echarts.js"></script>
<script src="assets/plugins/echarts/3.7.2/theme/macarons.js"></script>
<script src="assets/commons/js/sub_index.js"></script>
<script>
$(function(){
	Index.orderChart();
	Index.userChart();
});
</script>
<%@ include file="commons/footer.jsp" %>