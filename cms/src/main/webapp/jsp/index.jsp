<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp" %>
<div class="row">
<div class="col-sm-8">
	<div class="ibox float-e-margins">
		<div class="ibox-title" style="border-bottom:none;background:#fff;">
			<h5>任务列表</h5>
		</div>
		<div class="ibox-content" style="border-top:none;">
			<div class="row m-b-sm m-t-sm">
				<div class="col-md-1">
					<button type="button" id="loading-example-btn" class="btn btn-white btn-sm"><i class="fa fa-refresh"></i> 刷新</button>
				</div>
				<div class="col-md-4">
					<div class="input-group">
						<input type="text" placeholder="请输入项目名称" class="input-sm form-control"> <span class="input-group-btn">
                                            <button type="button" class="btn btn-sm btn-primary"> 搜索</button> </span>
					</div>
				</div>
			</div>
			<div class="project-list">
				<table class="table table-hover">
					<tbody>
						<tr>
							<td class="project-status">
								<span class="label label-primary">进行中
                                            </span></td>
							<td class="project-title">
								<a href="project_detail.html">LIKE－一款能够让用户快速获得认同感的兴趣社交应用</a>
								<br>
								<small>创建于 2014.08.15</small>
							</td>
							<td class="project-completion">
								<small>当前进度： 48%</small>
								<div class="progress progress-mini">
									<div style="width: 48%;" class="progress-bar"></div>
								</div>
							</td>
							<td class="project-people">
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head3.jpg"></a>
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head1.jpg"></a>
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head2.jpg"></a>
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head3.jpg"></a>
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head4.jpg"></a>
							</td>
							<td class="project-actions">
								<a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a>
								<a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a>
							</td>
						</tr>
						<tr>
							<td class="project-status">
								<span class="label label-primary">进行中
                                            </span></td>
							<td class="project-title">
								<a href="project_detail.html">米莫说｜MiMO Show</a>
								<br>
								<small>创建于 2014.08.15</small>
							</td>
							<td class="project-completion">
								<small>当前进度： 28%</small>
								<div class="progress progress-mini">
									<div style="width: 28%;" class="progress-bar"></div>
								</div>
							</td>
							<td class="project-people">
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head4.jpg"></a>
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head3.jpg"></a>
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head3.jpg"></a>
							</td>
							<td class="project-actions">
								<a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a>
								<a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a>
							</td>
						</tr>
						<tr>
							<td class="project-status">
								<span class="label label-default">已取消
                                            </span></td>
							<td class="project-title">
								<a href="project_detail.html">商家与购物用户的交互试衣应用</a>
								<br>
								<small>创建于 2014.08.15</small>
							</td>
							<td class="project-completion">
								<small>当前进度： 8%</small>
								<div class="progress progress-mini">
									<div style="width: 8%;" class="progress-bar"></div>
								</div>
							</td>
							<td class="project-people">
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head4.jpg"></a>
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head3.jpg"></a>
							</td>
							<td class="project-actions">
								<a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a>
								<a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a>
							</td>
						</tr>
						<tr>
							<td class="project-status">
								<span class="label label-primary">进行中
                                            </span></td>
							<td class="project-title">
								<a href="project_detail.html">天狼---智能硬件项目</a>
								<br>
								<small>创建于 2014.08.15</small>
							</td>
							<td class="project-completion">
								<small>当前进度： 83%</small>
								<div class="progress progress-mini">
									<div style="width: 83%;" class="progress-bar"></div>
								</div>
							</td>
							<td class="project-people">
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head2.jpg"></a>
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head3.jpg"></a>
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head1.jpg"></a>
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head4.jpg"></a>
							</td>
							<td class="project-actions">
								<a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a>
								<a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a>
							</td>
						</tr>
						<tr>
							<td class="project-status">
								<span class="label label-primary">进行中
                                            </span></td>
							<td class="project-title">
								<a href="project_detail.html">乐活未来</a>
								<br>
								<small>创建于 2014.08.15</small>
							</td>
							<td class="project-completion">
								<small>当前进度： 97%</small>
								<div class="progress progress-mini">
									<div style="width: 97%;" class="progress-bar"></div>
								</div>
							</td>
							<td class="project-people">
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head3.jpg"></a>
							</td>
							<td class="project-actions">
								<a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a>
								<a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a>
							</td>
						</tr>
						<tr>
							<td class="project-status">
								<span class="label label-primary">进行中
                                            </span></td>
							<td class="project-title">
								<a href="project_detail.html">【私人医生项目】</a>
								<br>
								<small>创建于 2014.08.15</small>
							</td>
							<td class="project-completion">
								<small>当前进度： 48%</small>
								<div class="progress progress-mini">
									<div style="width: 48%;" class="progress-bar"></div>
								</div>
							</td>
							<td class="project-people">
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head1.jpg"></a>
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head2.jpg"></a>
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head3.jpg"></a>
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head4.jpg"></a>
							</td>
							<td class="project-actions">
								<a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a>
								<a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a>
							</td>
						</tr>
						<tr>
							<td class="project-status">
								<span class="label label-primary">进行中
                                            </span></td>
							<td class="project-title">
								<a href="project_detail.html">快狗家居</a>
								<br>
								<small>创建于 2014.08.15</small>
							</td>
							<td class="project-completion">
								<small>当前进度： 28%</small>
								<div class="progress progress-mini">
									<div style="width: 28%;" class="progress-bar"></div>
								</div>
							</td>
							<td class="project-people">
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head4.jpg"></a>
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head3.jpg"></a>
								<a href="projects.html"><img alt="image" class="img-circle-thumb" src="data/images/head3.jpg"></a>
							</td>
							<td class="project-actions">
								<a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a>
								<a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="ibox float-e-margins">
		<div class="ibox-title" style="border-bottom:none;background:#fff;">
			<h5>标签墙</h5>
			<a style="float: right;" href="javascript:void(0)">更多>></a>
		</div>
		<div class="ibox-content" style="border-top:none;height: 286px;">
			<ul class="notes">
				<li>
					<div>
						<small>2014年10月24日(星期五) 下午5:31</small>
						<h4>HTML5 文档类型</h4>
						<p>Bootstrap 使用到的某些 HTML 元素和 CSS 属性需要将页面设置为 HTML5 文档类型。在你项目中的每个页面都要参照下面的格式进行设置。</p>
						<a href="pin_board.html#"><i class="fa fa-trash-o "></i></a>
					</div>
				</li>
				<li>
					<div>
						<small>2014年10月24日(星期五) 下午5:31</small>
						<h4>移动设备优先</h4>
						<p>在 Bootstrap 2 中，我们对框架中的某些关键部分增加了对移动设备友好的样式。而在 Bootstrap 3 中，我们重写了整个框架，使其一开始就是对移动设备友好的。这次不是简单的增……</p>
						<a href="pin_board.html#"><i class="fa fa-trash-o "></i></a>
					</div>
				</li>
				<li>
					<div>
						<small>2014年10月24日(星期五) 下午5:31</small>
						<h4>排版与链接</h4>
						<p>Bootstrap 排版、链接样式设置了基本的全局样式。分别是： 为 body 元素设置 background-color: #fff; 使用 @font-family-base、@font-size-base 和……。</p>
						<a href="pin_board.html#"><i class="fa fa-trash-o "></i></a>
					</div>
				</li>
				<li>
					<div>
						<small>2014年10月24日(星期五) 下午5:31</small>
						<h4>Normalize.css</h4>
						<p>为了增强跨浏览器表现的一致性，我们使用了 Normalize.css，这是由 Nicolas Gallagher 和 Jonathan Neal 维护的一个CSS 重置样式库。</p>
						<a href="pin_board.html#"><i class="fa fa-trash-o "></i></a>
					</div>
				</li>
			</ul>
		</div>
	</div>
</div>
<!--
            	作者：zero1814@126.com
            	时间：2017-04-05
            	描述：个人信息
            -->
<div class="col-sm-4">
	<div class="ibox float-e-margins">
		<div class="ibox-title" style="border-bottom:none;background:#fff;">
			<h5>个人信息</h5>
		</div>
		<div class="ibox-content" style="border-top:none;">
			<div>
				<img style="display: block;margin: 0 auto;" alt="image" class="img-circle" src="data/images/head2.jpg">
			</div>
			<h4><strong>admin</strong></h4>
			<p><i class="fa fa-map-marker"></i>测试技术有限公司<span style="padding-left: 10px;">技术部-张三</span></p>
			<p><i class="fa fa-mail-forward"></i>邮箱地址</p>
			<div class="user-button">
				<div class="row">
					<div class="col-sm-6">
						<button type="button" class="btn btn-primary btn-sm btn-block"><i class="fa fa-envelope"></i> 发送消息</button>
					</div>
					<div class="col-sm-6">
						<button type="button" class="btn btn-default btn-sm btn-block"><i class="fa fa-sign-out"></i> 注销</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="ibox float-e-margins">
		<div class="ibox-title" style="border-bottom:none;background:#fff;">
			<h5>今日安排</h5>
		</div>
		<div class="ibox-content" style="border-top:none;">
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
<%@ include file="common/footer.jsp" %> 