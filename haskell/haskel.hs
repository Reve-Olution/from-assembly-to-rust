hello :: String -> String
hello x = "Hello " ++ x

double :: Integer -> Integer
double x
  | even x = 0
  | otherwise = x * 2

total = foldl (+) 0 [1,2,3,4,5]

main :: IO()
--main = putStrLn (show total)
--main = (show <$> (double <$> (read <$> getLine))) >>= putStrLn
--main = (double <$> getLine) >>= putStrLn

main = do
  line <- getLine
  putStrLn (show(double(read(line))))
