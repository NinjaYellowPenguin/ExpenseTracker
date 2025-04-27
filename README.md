<div class="mb-4 rounded-lg border bg-linear-to-b from-gray-100 to-white to-10% p-4 py-2 sm:p-5"> <div class="relative">  <div class="my-2 flex items-center justify-between gap-2 sm:my-7"> <div class=""> <h1 class="mb-1 text-xl font-semibold sm:mb-2 sm:text-3xl"> Expense Tracker </h1> <p class="text-sm text-balance text-gray-500"> Build a simple expense tracker to manage your finances. </p> </div>  </div> </div> <astro-island uid="LgknT" prefix="r14" component-url="/_astro/ProjectStepper.DVJDYZDp.js" component-export="ProjectStepper" renderer-url="/_astro/client.DNdMcqFj.js" props="{&quot;projectId&quot;:[0,&quot;expense-tracker&quot;]}" client="load" opts="{&quot;name&quot;:&quot;ProjectStepper&quot;,&quot;value&quot;:true}" await-children=""></astro-island> <div class="prose prose-h2:mb-3 prose-h2:mt-5 prose-h3:mb-1 prose-h3:mt-5 prose-p:mb-2 prose-blockquote:font-normal prose-blockquote:text-gray-500 prose-pre:my-3 prose-ul:my-3.5 prose-hr:my-5 max-w-full [&amp;>ul>li]:my-1"> <p>Build a simple expense tracker application to manage your finances. The application should allow users to add, delete, and view their expenses. The application should also provide a summary of the expenses.</p>
<h2 id="requirements">Requirements</h2>
<p>Application should run from the command line and should have the following features:</p>
<ul>
<li>Users can add an expense with a description and amount.</li>
<li>Users can update an expense.</li>
<li>Users can delete an expense.</li>
<li>Users can view all expenses.</li>
<li>Users can view a summary of all expenses.</li>
<li>Users can view a summary of expenses for a specific month (of current year).</li>
</ul>
<p>Here are some additional features that you can add to the application:</p>
<ul>
<li>Add expense categories and allow users to filter expenses by category.</li>
<li>Allow users to set a budget for each month and show a warning when the user exceeds the budget.</li>
<li>Allow users to export expenses to a CSV file.</li>
</ul>
<p>The list of commands and their expected output is shown below:</p>
<pre class="astro-code dracula" style="background-color:#282A36;color:#F8F8F2; overflow-x: auto;" tabindex="0" data-language="bash"><code><span class="line"><span style="color:#50FA7B">$</span><span style="color:#F1FA8C"> expense-tracker</span><span style="color:#F1FA8C"> add</span><span style="color:#BD93F9"> --description</span><span style="color:#E9F284"> "</span><span style="color:#F1FA8C">Lunch</span><span style="color:#E9F284">"</span><span style="color:#BD93F9"> --amount</span><span style="color:#BD93F9"> 20</span></span>
<span class="line"><span style="color:#6272A4"># Expense added successfully (ID: 1)</span></span>
<span class="line"></span>
<span class="line"><span style="color:#50FA7B">$</span><span style="color:#F1FA8C"> expense-tracker</span><span style="color:#F1FA8C"> add</span><span style="color:#BD93F9"> --description</span><span style="color:#E9F284"> "</span><span style="color:#F1FA8C">Dinner</span><span style="color:#E9F284">"</span><span style="color:#BD93F9"> --amount</span><span style="color:#BD93F9"> 10</span></span>
<span class="line"><span style="color:#6272A4"># Expense added successfully (ID: 2)</span></span>
<span class="line"></span>
<span class="line"><span style="color:#50FA7B">$</span><span style="color:#F1FA8C"> expense-tracker</span><span style="color:#F1FA8C"> list</span></span>
<span class="line"><span style="color:#6272A4"># ID  Date       Description  Amount</span></span>
<span class="line"><span style="color:#6272A4"># 1   2024-08-06  Lunch        $20</span></span>
<span class="line"><span style="color:#6272A4"># 2   2024-08-06  Dinner       $10</span></span>
<span class="line"></span>
<span class="line"><span style="color:#50FA7B">$</span><span style="color:#F1FA8C"> expense-tracker</span><span style="color:#F1FA8C"> summary</span></span>
<span class="line"><span style="color:#6272A4"># Total expenses: $30</span></span>
<span class="line"></span>
<span class="line"><span style="color:#50FA7B">$</span><span style="color:#F1FA8C"> expense-tracker</span><span style="color:#F1FA8C"> delete</span><span style="color:#BD93F9"> --id</span><span style="color:#BD93F9"> 2</span></span>
<span class="line"><span style="color:#6272A4"># Expense deleted successfully</span></span>
<span class="line"></span>
<span class="line"><span style="color:#50FA7B">$</span><span style="color:#F1FA8C"> expense-tracker</span><span style="color:#F1FA8C"> summary</span></span>
<span class="line"><span style="color:#6272A4"># Total expenses: $20</span></span>
<span class="line"></span>
<span class="line"><span style="color:#50FA7B">$</span><span style="color:#F1FA8C"> expense-tracker</span><span style="color:#F1FA8C"> summary</span><span style="color:#BD93F9"> --month</span><span style="color:#BD93F9"> 8</span></span>
<span class="line"><span style="color:#6272A4"># Total expenses for August: $20</span></span></code></pre>
<h2 id="implementation">Implementation</h2>
<p>You can implement the application using any programming language of your choice. Here are some suggestions:</p>
<ul>
<li>Use any programming language for any available module for parsing command arguments (e.g. python with the <code>argparse</code>, node.js with <code>commander</code> etc).</li>
<li>Use a simple text file to store the expenses data. You can use JSON, CSV, or any other format to store the data.</li>
<li>Add error handling to handle invalid inputs and edge cases (e.g. negative amounts, non-existent expense IDs, etc).</li>
<li>Use functions to modularize the code and make it easier to test and maintain.</li>
</ul>
<hr>
<p>This project idea is a great way to practice your logic building skills and learn how to interact with the filesystem using a CLI application. It will also help you understand how to manage data and provide useful information to users in a structured way.</p> </div> <div class="mt-5 flex flex-wrap items-center justify-center rounded-lg p-2.5 text-sm"> <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 98 96" xmlns:v="https://vecta.io/nano" class="mr-2 inline-block h-5 w-5"><path fill-rule="evenodd" d="M48.854 0C21.839 0 0 22 0 49.217c0 21.756 13.993 40.172 33.405 46.69 2.427.49 3.316-1.059 3.316-2.362l-.08-9.127c-13.59 2.934-16.42-5.867-16.42-5.867-2.184-5.704-5.42-7.17-5.42-7.17-4.448-3.015.324-3.015.324-3.015 4.934.326 7.523 5.052 7.523 5.052 4.367 7.496 11.404 5.378 14.235 4.074.404-3.178 1.699-5.378 3.074-6.6-10.839-1.141-22.243-5.378-22.243-24.283 0-5.378 1.94-9.778 5.014-13.2-.485-1.222-2.184-6.275.486-13.038 0 0 4.125-1.304 13.426 5.052a46.97 46.97 0 0 1 12.214-1.63c4.125 0 8.33.571 12.213 1.63 9.302-6.356 13.427-5.052 13.427-5.052 2.67 6.763.97 11.816.485 13.038 3.155 3.422 5.015 7.822 5.015 13.2 0 18.905-11.404 23.06-22.324 24.283 1.78 1.548 3.316 4.481 3.316 9.126l-.08 13.526c0 1.304.89 2.853 3.316 2.364 19.412-6.52 33.405-24.935 33.405-46.691C97.707 22 75.788 0 48.854 0z" fill="currentColor"></path></svg>
Found a mistake?
<a class="ml-1 underline underline-offset-2" href="https://github.com/kamranahmedse/developer-roadmap/tree/master/src/data/projects/expense-tracker.md" target="_blank">
Help us improve.
</a> </div> </div>
