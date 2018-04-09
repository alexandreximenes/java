   $(function(){

   	  $('.top').hide();

      $('#menu-slicknav').slicknav({
      	label: '',
      	closeOnClick: true

      });

      $('.actors').click(function(){
    	var actor = $('.actor').offset().top;	
    	animar(actor);	
      });

      $('.info').click(function(){
      	var about = $('.about').offset().top;
      	animar(about);
      });

      $('.adress').click(function(){
      	var contact = $('.contact').offset().top;
      	animar(contact);
      });

      $('.networks').click(function(){
      	var redes = $('.footer').offset().top;
      	animar(redes);
      });

      // $('#contact').click(function(){
      // 	var contact = $('.contact').offset().top;
      // 	animar(contact);
      // });

      $('.contacts').click(function(){
      	var questions = $('.questions').offset().top;
      	animar(questions);
      });

      $('.top').click(function(){
      	var top = $('.logotype').offset().top;
      	animar(top);
      	$('.top').hide();
      });
      
      function animar(classe){
      	  $("body").animate({
      		scrollTop: classe + "px"
      	},1000);
      	$('.top').show();
      }
      
      $('.leia-mais').click(function(event){
    	  event.preventDefault();
    	  $('.modal-fundo').show();
      });
      
      $('.voltar').click(function(event){
    	  event.preventDefault();
    	  $('.modal-fundo').hide();
      });


      $('.bxslider').bxSlider({
      	mode: 'fade',
      	auto: true,
  		autoControls: false,
  		infiniteLoop: true,
  		easing: 'swing',
  		pause: 3000
  		/*
		  mode: 'horizontal',                 // 'horizontal', 'vertical', 'fade'
		  childSelector: '',                  // jQuery selector - elements to be used as slides
		  infiniteLoop: true,                 // true, false - display first slide after last
		  hideControlOnEnd: false,            // true, false - if true, will hide 'next' control on last slide and 'prev' control on first
		  controls: true,                     // true, false - previous and next controls
		  speed: 500,                         // integer - in ms, duration of time slide transitions will occupy
		  easing: 'swing',                    // used with jquery.easing.1.3.js - see http://gsgd.co.uk/sandbox/jquery/easing/ for available options
		  pager: false,                       // true / false - display a pager
		  pagerSelector: null,                // jQuery selector - element to contain the pager. ex: '#pager'
		  pagerType: 'full',                  // 'full', 'short' - if 'full' pager displays 1,2,3... if 'short' pager displays 1 / 4
		  pagerLocation: 'bottom',            // 'bottom', 'top' - location of pager
		  pagerShortSeparator: '/',           // string - ex: 'of' pager would display 1 of 4
		  pagerActiveClass: 'pager-active',   // string - classname attached to the active pager link
		  nextText: 'next',                   // string - text displayed for 'next' control
		  nextImage: '',                      // string - filepath of image used for 'next' control. ex: 'images/next.jpg'
		  nextSelector: null,                 // jQuery selector - element to contain the next control. ex: '#next'
		  prevText: 'prev',                   // string - text displayed for 'previous' control
		  prevImage: '',                      // string - filepath of image used for 'previous' control. ex: 'images/prev.jpg'
		  prevSelector: null,                 // jQuery selector - element to contain the previous control. ex: '#next'
		  captions: false,                    // true, false - display image captions (reads the image 'title' tag)
		  captionsSelector: null,             // jQuery selector - element to contain the captions. ex: '#captions'
		  auto: false,                        // true, false - make slideshow change automatically
		  autoDirection: 'next',              // 'next', 'prev' - direction in which auto show will traverse
		  autoControls: false,                // true, false - show 'start' and 'stop' controls for auto show
		  autoControlsSelector: null,         // jQuery selector - element to contain the auto controls. ex: '#auto-controls'
		  autoStart: true,                    // true, false - if false show will wait for 'start' control to activate
		  autoHover: false,                   // true, false - if true show will pause on mouseover
		  autoDelay: 0,                       // integer - in ms, the amount of time before starting the auto show
		  pause: 3000,                        // integer - in ms, the duration between each slide transition
		  startText: 'start',                 // string - text displayed for 'start' control
		  startImage: '',                     // string - filepath of image used for 'start' control. ex: 'images/start.jpg'
		  stopText: 'stop',                   // string - text displayed for 'stop' control
		  stopImage: '',                      // string - filepath of image used for 'stop' control. ex: 'images/stop.jpg'
		  ticker: false,                      // true, false - continuous motion ticker mode (think news ticker)
		                                      // note: autoControls, autoControlsSelector, and autoHover apply to ticker!
		  tickerSpeed: 5000,                  // float - use value between 1 and 5000 to determine ticker speed - the smaller the value the faster the ticker speed
		  tickerDirection: 'next',            // 'next', 'prev' - direction in which ticker show will traverse
		  tickerHover: false,                 // true, false - if true ticker will pause on mouseover
		  wrapperClass: 'bx-wrapper',         // string - classname attached to the slider wraper
		  startingSlide: 0,                   // integer - show will start on specified slide. note: slides are zero based!
		  displaySlideQty: 1,                 // integer - number of slides to display at once
		  moveSlideQty: 1,                    // integer - number of slides to move at once
		  randomStart: false,                 // true, false - if true show will start on a random slide
		  onBeforeSlide: function(){},        // function(currentSlideNumber, totalSlideQty, currentSlideHtmlObject)
		  onAfterSlide: function(){},         // function(currentSlideNumber, totalSlideQty, currentSlideHtmlObject)
		  onLastSlide: function(){},          // function(currentSlideNumber, totalSlideQty, currentSlideHtmlObject)
		  onFirstSlide: function(){},         // function(currentSlideNumber, totalSlideQty, currentSlideHtmlObject)
		  onNextSlide: function(){},          // function(currentSlideNumber, totalSlideQty, currentSlideHtmlObject)
		  onPrevSlide: function(){},          // function(currentSlideNumber, totalSlideQty, currentSlideHtmlObject)
		  buildPager: null,                   // function(slideIndex, slideHtmlObject){ return string; }

  		*/

      });
    });




 