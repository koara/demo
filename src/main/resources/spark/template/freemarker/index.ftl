
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="author" content="Andy Van Den Heuvel">
		<title>Koara - A Modular Lightweight Markup Language</title>
		<link rel="stylesheet" type="text/css" href="http://koara.io/a.css" media="all">
		<link rel="shortcut icon" href="http://koara.io/favicon.png" />
	</head>
  	<body>
  		<div id="wr">
	    	<form action="/" method="post">
	    		<p><a href="/"><img src="http://koara.io/logo.png" alt="Koara" /></a></p>
	    		
	    		
	    		<ul id="nv">
				  <li>
				  	<input id="paragraphs" type="checkbox" name="modules" value="paragraphs"${modules?seq_contains("paragraphs")?string('checked="checked"', '')}> 
				  	<label for="paragraphs">Paragraphs</label>
				  </li>
				  <li>
				  	<input id="headings" type="checkbox" name="modules" value="headings"${modules?seq_contains("headings")?string('checked="checked"', '')}> 
				  	<label for="headings">Headings</label>
				  </li>
				  <li>
				  	<input id="lists" type="checkbox" name="modules" value="lists"${modules?seq_contains("lists")?string('checked="checked"', '')}> 
				  	<label for="lists">Lists</label>
				  </li>
				  <li>
				  	<input id="links" type="checkbox" name="modules" value="links"${modules?seq_contains("links")?string('checked="checked"', '')}> 
				  	<label for="links">Links</label>
				  </li>
				  <li>
				  	<input id="images" type="checkbox" name="modules" value="images"${modules?seq_contains("images")?string('checked="checked"', '')}> 
				  	<label for="images">Images</label>
				  </li>
				  <li>
				  	<input id="formatting" type="checkbox" name="modules" value="formatting"${modules?seq_contains("formatting")?string('checked="checked"', '')}> 
				  	<label for="formatting">Formatting</label>
				  </li>
				  <li>
				  	<input id="blockquotes" type="checkbox" name="modules" value="blockquotes"${modules?seq_contains("blockquotes")?string('checked="checked"', '')}> 
				  	<label for="blockquotes">Blockquotes</label>
				  </li>
				  <li>
				  	<input id="code" type="checkbox" name="modules" value="code"${modules?seq_contains("code")?string('checked="checked"', '')}> 
				  	<label for="code">Code</label>
				  </li>
				</ul>
				
				<p><textarea name="input" style="width:100%; height: 220px">${input}</textarea></p>
	
				
				
				<p><input type="submit" value="Convert"><p>
			</form>
			<#if output??>
			  	<p><em>Html:</em></p>	
				<p><textarea style="width:100%; height: 220px">${output}</textarea></p>
				<p><em>Output:</em></p>	
				${output}
			</#if>	
			</form>
		</div>
	</body>
</html>