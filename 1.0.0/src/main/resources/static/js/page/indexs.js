$(function(){
	var key = 0;
	var prev = 0;
	out();
	//滑轮滚动事件
	$(document).mousewheel(function(event,delta){
		//如果没有处于执行动画状态，方可执行
		if(!$('.wrapBox').is(':animated')){
			key = getKey(key - delta);
			$('.wrapBox').stop(true).animate({top:-key*100 + '%'},1000);	
			$('.nav li').eq(key).addClass('current').siblings().removeClass('current');	
		}
		out();
		prev = key;
	});
	var getKey = function(k){
		return k < 0 || k > $('.nav li').length-1 ? 0 : k;
	}
	var arr = ['bootbase','menu']
	$('.nav li').bind({
		mouseenter:function(){
			$(this).append('<span>'+arr[$(this).index()]+'</span>');
		},
		mouseleave:function(){
			$(this).find('span').remove();
		},
		click:function(){
			key = $(this).index();
			$('.wrapBox').stop(true).animate({top:-key*100 + '%'},1000);
			$(this).addClass('current').siblings().removeClass('current');
			out();
			prev = key;
		}
	});
	
	//通过按钮点击第一屏动画显示
	$('button:first').click(function(){
		$('.box').removeClass('comeout');
	});
	function out(){
		$('.box').eq(prev).addClass('comeout');
		$('.box').eq(key).removeClass('comeout');
	}
	
});