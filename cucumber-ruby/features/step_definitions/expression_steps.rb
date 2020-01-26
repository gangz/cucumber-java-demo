require 'open3'
require "rspec/expectations" 
require 'shellwords'

def call_calc (expr, result)
    cmd = 'java -jar expression.jar ' + Shellwords.shellescape(expr)
    Open3.popen3(cmd) do |stdin, stdout, stderr, wait_thr|
      expect(stdout.read).to eq result
    end
end


假如(/^表达式是'(.*)'$/) do |expr|
  @expr = expr
end

假如(/^结果应该是'(.*)'$/) do |result|
  call_calc @expr, result
end

