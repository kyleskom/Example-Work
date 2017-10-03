import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class interpreter {
	static ArrayList<ArrayList<String>> stack = new ArrayList<ArrayList<String>>();
	static ArrayList<HashMap<String, String>> map = new ArrayList<HashMap<String, String>>();
	static String[] word = new String[0];
	static Map<String, ArrayList<String>> funmap = new HashMap<String, ArrayList<String>>();
	
	public static boolean isName(String s) {
		if (s.startsWith("\"") && s.endsWith("\"")) {
			return false;
		} else if (Character.isLetter(s.charAt(0)) && s.matches("[a-zA-Z0-9]*")) {
			return true;
		} else {
			return false;
		}
	}

	public static String contains(String s) {
		for (int i = map.size() - 1; i >= 0; i--) {
			if (map.get(i).containsKey(s)) {
				return (String) map.get(i).get(s);
			}
		}
		return ":error:";
	}

	public static void add() {
		if (stack.get(stack.size() - 1).size() < 2) {
			stack.get(stack.size() - 1).add(":error:");
		} else {
			String s1 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s2 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s3 = s1;
			String s4 = s2;
			if (isName(s1)) {
				s1 = contains(s1);
			}
			if (isName(s2)) {
				s2 = contains(s2);
			}
			if (s1.matches("^-?\\d+$") && s2.matches("^-?\\d+$")) {
				int x = Integer.parseInt(s1);
				int y = Integer.parseInt(s2);
				int result = x + y;
				stack.get(stack.size() - 1).add(String.valueOf(result));
			} else {
				stack.get(stack.size() - 1).add(s4);
				stack.get(stack.size() - 1).add(s3);
				stack.get(stack.size() - 1).add(":error:");
			}
		}
	}

	public static void sub() {
		if (stack.get(stack.size() - 1).size() < 2) {
			stack.get(stack.size() - 1).add(":error:");
		} else {
			String s1 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			;
			String s2 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			;
			String s3 = s1;
			String s4 = s2;
			if (isName(s1)) {
				s1 = contains(s1);
			}
			if (isName(s2)) {
				s2 = contains(s2);
			}
			if (s1.matches("^-?\\d+$") && s2.matches("^-?\\d+$")) {
				int x = Integer.parseInt(s1);
				int y = Integer.parseInt(s2);
				int result = y - x;
				stack.get(stack.size() - 1).add(String.valueOf(result));
			} else {
				stack.get(stack.size() - 1).add(s4);
				stack.get(stack.size() - 1).add(s3);
				stack.get(stack.size() - 1).add(":error:");
			}
		}
	}

	public static void mul() {
		if (stack.get(stack.size() - 1).size() < 2) {
			stack.get(stack.size() - 1).add(":error:");
		} else {
			String s1 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s2 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s3 = s1;
			String s4 = s2;
			if (isName(s1)) {
				s1 = contains(s1);
			}
			if (isName(s2)) {
				s2 = contains(s2);
			}
			if (s1.matches("^-?\\d+$") && s2.matches("^-?\\d+$")) {
				int x = Integer.parseInt(s1);
				int y = Integer.parseInt(s2);
				int result = y * x;
				stack.get(stack.size() - 1).add(String.valueOf(result));
			} else {
				stack.get(stack.size() - 1).add(s4);
				stack.get(stack.size() - 1).add(s3);
				stack.get(stack.size() - 1).add(":error:");
			}
		}
	}

	public static void div() {
		if (stack.get(stack.size() - 1).size() < 2) {
			stack.get(stack.size() - 1).add(":error:");
		} else {
			String s1 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s2 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s3 = s1;
			String s4 = s2;
			if (isName(s1)) {
				s1 = contains(s1);
			}
			if (isName(s2)) {
				s2 = contains(s2);
			}
			if (s1.matches("^-?\\d+$") && s2.matches("^-?\\d+$")) {
				int x = Integer.parseInt(s1);
				int y = Integer.parseInt(s2);
				if (x == 0) {
					stack.get(stack.size() - 1).add(s4);
					stack.get(stack.size() - 1).add(s3);
					stack.get(stack.size() - 1).add(":error:");
				} else {
					int result = y / x;
					stack.get(stack.size() - 1).add(String.valueOf(result));
				}
			} else {
				stack.get(stack.size() - 1).add(s4);
				stack.get(stack.size() - 1).add(s3);
				stack.get(stack.size() - 1).add(":error:");
			}
		}
	}

	public static void rem() {
		if (stack.get(stack.size() - 1).size() < 2) {
			stack.get(stack.size() - 1).add(":error:");
		} else {
			String s1 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s2 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s3 = s1;
			String s4 = s2;
			if (isName(s1)) {
				s1 = contains(s1);
			}
			if (isName(s2)) {
				s2 = contains(s2);
			}
			if (s1.matches("^-?\\d+$") && s2.matches("^-?\\d+$")) {
				int x = Integer.parseInt(s1);
				int y = Integer.parseInt(s2);
				if (x == 0) {
					stack.get(stack.size() - 1).add(s4);
					stack.get(stack.size() - 1).add(s3);
					stack.get(stack.size() - 1).add(":error:");
				} else {
					int result = y % x;
					stack.get(stack.size() - 1).add(String.valueOf(result));
				}
			} else {
				stack.get(stack.size() - 1).add(s4);
				stack.get(stack.size() - 1).add(s3);
				stack.get(stack.size() - 1).add(":error:");
			}
		}
	}

	public static void neg() {
		if (stack.get(stack.size() - 1).size() < 1) {
			stack.get(stack.size() - 1).add(":error:");
		} else {
			String s1 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s2 = s1;
			if (isName(s1)) {
				s1 = contains(s1);
			}
			if (s1.matches("^-?\\d+$")) {
				int x = Integer.parseInt(s1);
				x = -x;
				stack.get(stack.size() - 1).add(String.valueOf(x));
			} else {
				stack.get(stack.size() - 1).add(s2);
				stack.get(stack.size() - 1).add(":error:");
			}
		}
	}

	public static void swap() {
		if (stack.get(stack.size() - 1).size() < 2) {
			stack.get(stack.size() - 1).add(":error:");
		} else {
			String temp1 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String temp2 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			stack.get(stack.size() - 1).add(temp1);
			stack.get(stack.size() - 1).add(temp2);
		}
	}

	public static boolean isBoolean(String s) {
		if (s.equals(":true:") || s.equals(":false:")) {
			return true;
		} else {
			return false;
		}
	}

	public static void and() {
		if (stack.get(stack.size() - 1).size() < 2) {
			stack.get(stack.size() - 1).add(":error:");
		} else {
			String s1 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s2 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s3 = s1;
			String s4 = s2;
			if (isName(s1)) {
				s1 = contains(s1);
			}
			if (isName(s2)) {
				s2 = contains(s2);
			}
			if (isBoolean(s1) && isBoolean(s2)) {
				if (s1.equals(":true:") && s2.equals(":true:")) {
					stack.get(stack.size() - 1).add(":true:");
				} else {
					stack.get(stack.size() - 1).add(":false:");
				}
			} else {
				stack.get(stack.size() - 1).add(s4);
				stack.get(stack.size() - 1).add(s3);
				stack.get(stack.size() - 1).add(":error:");
			}
		}
	}

	public static void or() {
		if (stack.get(stack.size() - 1).size() < 2) {
			stack.get(stack.size() - 1).add(":error:");
		} else {
			String s1 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s2 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s3 = s1;
			String s4 = s2;
			if (isName(s1)) {
				s1 = contains(s1);
			}
			if (isName(s2)) {
				s2 = contains(s2);
			}
			if (isBoolean(s1) && isBoolean(s2)) {
				if (s1.equals(":true:") || s2.equals(":true:")) {
					stack.get(stack.size() - 1).add(":true:");
				} else {
					stack.get(stack.size() - 1).add(":false:");
				}
			} else {
				stack.get(stack.size() - 1).add(s4);
				stack.get(stack.size() - 1).add(s3);
				stack.get(stack.size() - 1).add(":error:");
			}
		}
	}

	public static void not() {
		if (stack.get(stack.size() - 1).size() < 1) {
			stack.get(stack.size() - 1).add(":error:");
		} else {
			String s1 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s2 = s1;
			if (isName(s1)) {
				s1 = contains(s1);
			}
			if (isBoolean(s1)) {
				if (s1.equals(":true:")) {
					stack.get(stack.size() - 1).add(":false:");
				} else {
					stack.get(stack.size() - 1).add(":true:");
				}
			} else {
				stack.get(stack.size() - 1).add(s2);
				stack.get(stack.size() - 1).add(":error:");
			}
		}
	}

	public static void equal() {
		if (stack.get(stack.size() - 1).size() < 2) {
			stack.get(stack.size() - 1).add(":error:");
		} else {
			String s1 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s2 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s3 = s1;
			String s4 = s2;
			if (isName(s1)) {
				s1 = contains(s1);
			}
			if (isName(s2)) {
				s2 = contains(s2);
			}
			if (s1.matches("^-?\\d+$") && s2.matches("^-?\\d+$")) {
				int x = Integer.parseInt(s1);
				int y = Integer.parseInt(s2);
				if (x == y) {
					stack.get(stack.size() - 1).add(":true:");
				} else {
					stack.get(stack.size() - 1).add(":false:");
				}
			} else {
				stack.get(stack.size() - 1).add(s4);
				stack.get(stack.size() - 1).add(s3);
				stack.get(stack.size() - 1).add(":error:");
			}
		}
	}

	public static void lessThan() {
		if (stack.get(stack.size() - 1).size() < 2) {
			stack.get(stack.size() - 1).add(":error:");
		} else {
			String s1 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s2 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s3 = s1;
			String s4 = s2;
			if (isName(s1)) {
				s1 = contains(s1);
			}
			if (isName(s2)) {
				s2 = contains(s2);
			}
			if (s1.matches("^-?\\d+$") && s2.matches("^-?\\d+$")) {
				int x = Integer.parseInt(s1);
				int y = Integer.parseInt(s2);
				if (x > y) {
					stack.get(stack.size() - 1).add(":true:");
				} else {
					stack.get(stack.size() - 1).add(":false:");
				}
			} else {
				stack.get(stack.size() - 1).add(s4);
				stack.get(stack.size() - 1).add(s3);
				stack.get(stack.size() - 1).add(":error:");
			}
		}
	}

	public static void ifOp() {
		if (stack.get(stack.size() - 1).size() < 3) {
			stack.get(stack.size() - 1).add(":error:");
		} else {
			String s1 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s2 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s3 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s4 = s3;
			if (isName(s3)) {
				s3 = contains(s3);
			}
			if (isBoolean(s3)) {
				if (s3.equals(":true:")) {
					stack.get(stack.size() - 1).add(s1);
				} else {
					stack.get(stack.size() - 1).add(s2);
				}
			} else {
				stack.get(stack.size() - 1).add(s4);
				stack.get(stack.size() - 1).add(s2);
				stack.get(stack.size() - 1).add(s1);
				stack.get(stack.size() - 1).add(":error:");
			}
		}
	}

	public static void bind() {
		if (stack.get(stack.size() - 1).size() < 2) {
			stack.get(stack.size() - 1).add(":error:");
		} else {
			String s1 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			String s2 = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
			if (isName(s2)) {
				if (isName(s1)) {
					if (contains(s1).equals(":error:")) {
						stack.get(stack.size() - 1).add(s2);
						stack.get(stack.size() - 1).add(s1);
						stack.get(stack.size() - 1).add(":error:");
					} else {
						map.get(map.size() - 1).put(s2, contains(s1));
						stack.get(stack.size() - 1).add(":unit:");
					}
				} else {
					if (s1.equals(":error:") || s2.equals(":error:")) {
						stack.get(stack.size() - 1).add(s2);
						stack.get(stack.size() - 1).add(s1);
						stack.get(stack.size() - 1).add(":error:");
					} else {
						map.get(map.size() - 1).put(s2, s1);
						stack.get(stack.size() - 1).add(":unit:");
					}
				}
			} else {
				stack.get(stack.size() - 1).add(s2);
				stack.get(stack.size() - 1).add(s1);
				stack.get(stack.size() - 1).add(":error:");
			}
		}
	}

	public static void let() {
		stack.add(new ArrayList<String>());
		map.add(new HashMap<String, String>());
	}

	public static void end() {
		String temp = stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
		stack.remove(stack.size() - 1);
		stack.get(stack.size() - 1).add(temp);
		map.remove(map.size() - 1);
	}

	public static void interpreter(String input, String output) {
		stack.add(new ArrayList<String>());
		map.add(new HashMap<String, String>());
		try (BufferedReader br = new BufferedReader(new FileReader(input))) {
			String line;
			File file = new File(output);
			FileWriter fileWriter = new FileWriter(file);
			while ((line = br.readLine()) != null) {
				word = line.split("\\s+");
				if (word.length > 2) {
					for (int i = 2; i < word.length; i++) {
						word[1] = word[1] + " " + word[i];
					}
				}
				if (word[0].equals("push")) {
					if (word[1].equals("-0")) {
						word[1] = "0";
					}
					if (word[1].startsWith("\"") && word[1].endsWith("\"")) {
						stack.get(stack.size() - 1).add(word[1]);
						continue;
					}
					if (word[1].matches("^-?\\d+$")) {
						stack.get(stack.size() - 1).add(word[1]);
						continue;
					}
					if (((word[1].charAt(0) >= 'a' && word[1].charAt(0) <= 'z') || (word[1].charAt(0) >= 'A'))
							&& word[1].matches("[a-zA-Z0-9]*")) {
						stack.get(stack.size() - 1).add(word[1]);
						continue;
					} else {
						stack.get(stack.size() - 1).add(":error:");
					}

				} else if (word[0].equals("pop")) {
					if (stack.isEmpty()) {
						stack.get(stack.size() - 1).add(":error:");
					} else {
						stack.get(stack.size() - 1).remove((stack.get(stack.size() - 1).size()) - 1);
					}
				} else if (word[0].equals(":true:")) {
					stack.get(stack.size() - 1).add(":true:");
				} else if (word[0].equals(":false:")) {
					stack.get(stack.size() - 1).add(":false:");
				} else if (word[0].equals(":error:")) {
					stack.get(stack.size() - 1).add(":error:");
				} else if (word[0].equals("neg")) {
					neg();
				} else if (word[0].equals("add")) {
					add();
				} else if (word[0].equals("sub")) {
					sub();
				} else if (word[0].equals("mul")) {
					mul();
				} else if (word[0].equals("div")) {
					div();
				} else if (word[0].equals("rem")) {
					rem();
				} else if (word[0].equals("swap")) {
					swap();
				} else if (word[0].equals("and")) {
					and();
				} else if (word[0].equals("or")) {
					or();
				} else if (word[0].equals("not")) {
					not();
				} else if (word[0].equals("equal")) {
					equal();
				} else if (word[0].equals("lessThan")) {
					lessThan();
				} else if (word[0].equals("if")) {
					ifOp();
				} else if (word[0].equals("bind")) {
					bind();
				} else if (word[0].equals("let")) {
					let();
				} else if (word[0].equals("end")) {
					end();
				}
				else if (word[0].equals("quit")) {
					break;
				}
			}
			
			Collections.reverse(stack.get(stack.size() - 1));
			while (stack.get(stack.size() - 1).size() > 0) {
				String s = stack.get(stack.size() - 1).get(stack.size() - 1);
				if (s.startsWith("\"") && s.endsWith("\"")) {
					s = s.substring(1, s.length() - 1);
				}
				fileWriter.write(s + "\n");
				stack.get(stack.size() - 1).remove(stack.size() - 1);
			}
			fileWriter.close();
			System.exit(0);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}