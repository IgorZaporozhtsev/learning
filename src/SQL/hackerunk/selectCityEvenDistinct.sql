-- https://www.hackerrank.com/challenges/weather-observation-station-3/problem?isFullScreen=true

SELECT distinct(city)
FROM Station
WHERE (id % 2) = 0;