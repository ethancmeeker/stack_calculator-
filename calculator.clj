; this code only works if their is a interaction in the terminal
(defn calculation [op stack] ; I did have a bit of help with this function because it was confusing me and was the issue I was mainly having
    (let [[num1 num2 & tail] (reverse stack)] ; the reverse switches the stack around that way the code takes the top numbers rather than the back. 
         (->> (list op num1 num2) ; I still don't get the the ->> arrows that well but it works.
              eval ; this can evaluate the stack/array
              (conj tail) ; this tail recursion was something I stumbled upon early in the class and I my code wasn't working without it.
              reverse ; returns it back to it's normal state
              (apply vector)))) ; turns it back into a vector
(defn cal-eval [input stack] ; this assigns the symbol to divide or what not 
    (if (number? input)
        (conj stack input)
        (calculation input stack)))
(defn prompt [stack] ; this is basically how the inputs are done. It shows what needs to be shown when getting the input
    (pr stack) ; this shows the stack I have
    (print ">>> ") ; Just makes the interaction look nicer
    (flush)) ; found out about this just by searching online. The code worked when I used it so I'm keeping it. Don't know why this code works but it does.
(defn cal-reply [stack] ; looked up how to do inputs just so I could do this. Wasn't too hard, just needed to try it out and it worked
    (prompt stack)
    (let [input (read)]
        (recur
            (cal-eval input stack))))
(cal-reply[])
