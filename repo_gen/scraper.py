
import os, sys, shutil
import spynner
from lxml import etree

# initialize browser
def init_browser(url):
    b = spynner.Browser(debug_level=spynner.INFO)
    b.load(url)
    b.load_jquery(True)
    return b

if __name__ == "__main__":

    base_url = 'https://projecteuler.net/problem='
    prob_num = 1
    total_probs = 585
    
    problem_dir = '../problems'
    if not os.path.exists(problem_dir):
        os.makedirs(problem_dir)
        
    while prob_num < total_probs:
        
        # load site
        url = base_url+str(prob_num)    
        b = init_browser(url)
        title = ''
        err = True
        while err:
            try:
                # scrape title
                b = init_browser(url)
                site = etree.HTML(b.html)
                title = site.xpath('//h2/text()')[0].replace('/','//')
                print '\n'+str(prob_num)+'\n'+title+'\n'
                err = False
            except:
                # wait and try again
                b.wait(1)
                err = True

      
        # organize filestructure
        title = 'prob'+str(prob_num)+' - '+title
        filename = 'description.png'
        cur_dir = problem_dir+'/'+title
        if not os.path.exists(cur_dir):
            os.mkdir(cur_dir)
        
        # make file templates
        open(cur_dir+'/Makefile','w')
        open(cur_dir+'/sln.java','w')
        open(cur_dir+'/sln.mlx','w')
        open(cur_dir+'/sln.py','w')
        open(cur_dir+'/sln.c','w')
        open(cur_dir+'/sln.sh','w')
     
        # take description
        b.show()
        b.wait(1)
        b.snapshot().save(filename)
        b.close()
        
        shutil.move(filename,cur_dir)

        # goto next problem
        prob_num += 1
