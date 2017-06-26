<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量 
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。 
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
<jsp:include page="/pages/common/header.jsp"></jsp:include>
<head>
<link rel="shortcut icon" href="resources/images/title.ico"
	type="image/x-icon" />
<meta charset="UTF-8">
<title>事件本体以及突发事件语料库--CEC</title>
<link href="resources/css/index.css" rel="stylesheet">
<link href="resources/css/common.css" rel="stylesheet">
<script src="//cdn.bootcss.com/jquery/2.2.3/jquery.js"></script>
<link href="resources/css/common/sidebar.css" rel="stylesheet">
<script type="text/javascript" src="resources/js/common/sidebar.js"></script>
</head>
<body style="padding-left: 260px">
	<div class="container">
		<div>
			<img id="titleImgId"
				src="resources/images/navigation_images/head-background2.png" />
		</div>
		<jsp:include page="/pages/common/nav.jsp" />
		<div class="list-wrap w-1140">
			<div>
				<div class="link-title">
					<a href="https://github.com/daselab/CEC-Corpus">
						事件本体以及突发事件语料库--CEC（Chinese Emergency Corpus） </a>
				</div>


				<div class="directory">

					<ul>
						<li><h4 class="name">
								<a href="https://github.com/daselab/CEC-Corpus"><b>CEC语料库下载地址</b></a>
							</h4></li>

						<li><h4>
								<a href="https://github.com/daselab/CEEC-Corpus"><b>环境污染语料库下载地址</b></a>
							</h4></li>
						<!-- <li><h4>目录</h4></li>
						<li><a href="pages/corpus_profile.jsp#cec语料库引用"><h5>CEC语料库引用方式</h5></a></li>
						<li><a href="pages/corpus_profile.jsp#什么是本体"><h5>什么是本体?</h5></a></li>
						<li><a href="pages/corpus_profile.jsp#什么是事件"><h5>什么是事件?</h5></a></li>
						<li><a href="pages/corpus_profile.jsp#事件的定义是什么"><h5>事件的定义是什么？</h5></a></li>
						<li><a href="pages/corpus_profile.jsp#事件本体的定义是什么"><h5>事件本体的定义是什么？</h5></a></li>
						<li><a href="pages/corpus_profile.jsp#cec如何构建"><h5>CEC如何构建？</h5></a></li>
						<li><a href="pages/corpus_profile.jsp#主要标签图结构图"><h5>主要标签图结构图</h5></a></li>
						<li><a href="pages/corpus_profile.jsp#cec标注统计"><h5>CEC标注统计</h5></a></li> -->
					</ul>
				</div>
				<div id="article-content" class="article-content">
					<div class="markdown_views">
						<h3 id="cec语料库引用">1、CEC和CEEC语料库引用方式</h3>
						<h4>1.1 CEC语料库引用方式</h4>
						<p>中文：CEC中文突发事件语料库,
							https://github.com/daselab/CEC-Corpus,上海大学,2015</p>
						<p>英文：Chinese Emergency Corpus,
							https://github.com/daselab/CEC-Corpus, Shanghai University, 2015
						</p>
						<h4>1.2 CEEC语料库引用方式</h4>
						<p>中文：CEEC中文环境污染突发事件语料库,
							https://github.com/daselab/CEEC-Corpus,上海大学,2015</p>
						<p>英文：Chinese Environment Emergency Corpus,
							https://github.com/daselab/CEEC-Corpus, Shanghai University, 2015</p>

						<h3 id="什么是本体">
							<a name="t0"></a>2、什么是本体？
						</h3>

						<p>本体最初是一个哲学上的概念，十多年前被引入计算机领域中作为知识表示的方法并被广泛使用。Studer给出了本体的定义：“本体是共享概念模型的明确的形式化规范说明”。本体对于探索人的认知原理、发展自然语言理解技术和人机交互技术有重要意义。但是传统的本体模型存在着一系列的不足之处，1、作为知识的表示形式，在描述多远关系的能力上存在先天不足；2、认知科学家认为，人的概念大体可分为实体和事件，之前的研究更多关注的是大脑如何描绘实体而很少关注实体与事件的更本质的区别。</p>



						<h3 id="什么是事件">
							<a name="t1"></a>3、什么是事件？
						</h3>

						<p>
							世界是运动的，运动的世界是由事件组成的。事件是可以感知的、相对独立的、运动着的存在，它不同于静态概念。事件涉及多方面的实体，或称要素，包括时间要素、地点要素、参与者要素、过程状态要素。具有共同属性事件的集合的最大闭包称为事件类，或称为动态概念。事件类之间也具有包含关系，即由每个要素的属性的包含关系组成，这是一个多格结构。
							<br>
							世界的运动是绝对的，静止是相对的。任何实体都可以是事件要素的构成元素，不构成事件要素的实体是不存在的。事件是随着时间变化的具体事实。事件与事件之间具有本质的内在联系。
						</p>



						<h3 id="事件的定义是什么">
							<a name="t2"></a>4、事件的定义是什么？
						</h3>

						<p>
							定义1(事件) 指在某个特定的时间和环境下发生的、由若干角色参与、表现出若干动作特征的一件事情。形式上,事件可表示为e,
							定义为一个六元组:e =(A , O , T, V , P , L) <br> 其中, 事件六元组中的元素称为事件要素,
							分别表示动作、对象、时间、环境、断言、语言表现。 <br> A(动作):事件的变化过程及其特征,
							是对程度、方式、方法、工具等的描述, 例如快慢、使用什么、根据什么等等。 <br> O(对象):指事件的参与对象,
							包括参与事件的所有角色, 这些角色的类型数目称为对象序列长度。对象可分别是动作的施动者(主体)和受动者(客体)。 <br>
							T(时间):事件发生的时间段, 从事件发生的起点到事件结束的终点, 分为绝对时间段和相对时间段两类。 <br>
							V(环境):事件发生的场所及其特征等。例如:在小池塘里游泳, 场所:小池塘, 场所特征:水中。 <br>
							P(断言):断言由事件发生的前置条件、中间断言以及后置条件构成。前置条件指为进行该事件, 各要素应当或可能满足的约束条件,
							它们可以是事件发生的触发条件;中间断言指事件发生过程的中间状态各要素满足的条件;事件发生后,事件各要素将引起变化或者各要素状态的变迁,
							这些变化和变迁后的结果, 将成为事件的后置条件。 <br> L(语言表现):事件的语言表现规律,
							包括核心词集合、核心词表现、核心词搭配等。核心词是事件在句子中常用的标志性词汇。核心词表现则为在句子中各要素的表示与核心词之间的位置关系。核心词搭配是指核心词与其他词汇的固有的搭配。可以为事件附上不同语言种类的表现,
							例如中文、英文、法文等等。
						</p>



						<h3 id="事件本体的定义是什么">
							<a name="t3"></a>5、事件本体的定义是什么？
						</h3>

						<p>
							定义3(事件本体) 事件本体是共享的、客观存在的事件类系统模型的明确的形式化规范说明, 表示为EO。定义4(事件本体的结构)
							事件本体的逻辑结构可定义为一个三元结构EO :={ECS , R , Rules}, 这里,
							ECS(事件类集合)是所有事件类的集合。R(事件类之间的关系集合)包括事件类之间的分类关系和非分类关系。由分类关系可构成事件类层次。非分类关系上标明关系种类名和链接强度。链接强度用区间[
							0, 1] 之间的值来表示, 可通过学习或遗忘改变。Rules(规则)由逻辑语言表示,
							可用于事件断言所不能覆盖的部分事件与事件间的转换与推理。 <br> 事件本体作为一种面向事件的知识表示方法,
							更符合现实世界的存在规律和人类对现实世界的认知规律。过去的世界发生了许多的事件, 变成了今天的世界;今天的世界又将发生许多事件,
							变成明天的世界。描述变化的历史,
							就是描述这些发生的事件以及它们之间的关系。人类用话语文本表述,描述的只是事件及其关系的语言表现。要理解这些话语文本,
							就必须知道这些事件类丰富的内容, 这些内容的绝大部分是不可能在话语文本中叙述的,
							而是作为共同知识预先存在于每个交流者的头脑中。事件本体正是为计算机建造这样的共同知识。
						</p>



						<h3 id="cec如何构建">
							<a name="t4"></a>6、CEC如何构建？
						</h3>

						<p>
							事件本体是以“事件”为认知单元，研究事件的组成以及事件之间的关系，并对事件进行归纳和概括，形成事件类，进而构建事件本体模型。研究本体，必然要先构建语料库，所以在互联网上选取了突发事件语料来进行语料的事件标注，突发事件的分类体系，包括三个层次：一级4个大类（自然灾害类N、事故灾难类A、公共卫生事件P、社会安全事件S），二级33个子类，三级94个小类。我们标注的语料库称为CEC（Chinese
							Emergency Corpus），主要包括五类：地震、火灾、交通事故、恐怖袭击、食物中毒。合计332篇，下载地址为：<a
								href="https://github.com/shijiebei2009/CEC-Corpus">https://github.com/shijiebei2009/CEC-Corpus</a>
						</p>



						<h3 id="主要标签图结构图">
							<a name="t5"></a>7、主要标签图结构图
						</h3>

						<p>
							<img src="http://img.blog.csdn.net/20150322155421142"
								alt="这里写图片描述" title="">
						</p>

						<h3 id="cec标注统计">8、CEC标注统计</h3>

						<p>
							CEC是上海大学语义智能实验室构建的一个小规模语料库，合计332篇，共有5类，分别是地震、火灾、交通事故、恐怖袭击和食物中毒。CEC与ACE、TimeBank语料库相比，规模虽然偏小，但是对事件和事件要素的标注却更加全面。</p>
						<img width="800px" src="resources/images/bont/statisticsofcec.png"
							alt="CEC标注统计" title="">

					</div>
				</div>
			</div>
			<div class="sidebar-toggle">
				<div class="sidebar-toggle-line-wrap">
					<span class="sidebar-toggle-line" id="sidebar-line-first"></span> <span
						class="sidebar-toggle-line" id="sidebar-line-middle"></span> <span
						class="sidebar-toggle-line" id="sidebar-line-last"></span>
				</div>
			</div>
			<aside class="sidebar">
				<div class="sidebar-inner">

					<ul>
						<li><h4>目录</h4></li>
					</ul>
					<ol>
						<li><a href="pages/corpus_profile.jsp#cec语料库引用"><h5>1.CEC语料库引用方式</h5></a></li>
						<li><a href="pages/corpus_profile.jsp#什么是本体"><h5>2.什么是本体?</h5></a></li>
						<li><a href="pages/corpus_profile.jsp#什么是事件"><h5>3.什么是事件?</h5></a></li>
						<li><a href="pages/corpus_profile.jsp#事件的定义是什么"><h5>4.事件的定义是什么？</h5></a></li>
						<li><a href="pages/corpus_profile.jsp#事件本体的定义是什么"><h5>5.事件本体的定义是什么？</h5></a></li>
						<li><a href="pages/corpus_profile.jsp#cec如何构建"><h5>6.CEC如何构建？</h5></a></li>
						<li><a href="pages/corpus_profile.jsp#主要标签图结构图"><h5>7.主要标签图结构图</h5></a></li>
						<li><a href="pages/corpus_profile.jsp#cec标注统计"><h5>8.CEC标注统计</h5></a></li>
					</ol>
				</div>
			</aside>
		</div>
		<jsp:include page="/pages/common/foot.jsp" />
</body>
</html>