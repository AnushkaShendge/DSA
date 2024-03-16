class Node {
    int coef;
    int exp;
    Node next;

    Node(int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
        next = null;
    }
}

public class polyAddition {
    public static Node addPolynomials(Node poly1, Node poly2) {
        Node dummyHead = new Node(0, 0); // Dummy node to simplify code
        Node curr = dummyHead;

        while (poly1 != null && poly2 != null) {
            if (poly1.exp > poly2.exp) {
                curr.next = new Node(poly1.coef, poly1.exp);
                poly1 = poly1.next;
            } else if (poly1.exp < poly2.exp) {
                curr.next = new Node(poly2.coef, poly2.exp);
                poly2 = poly2.next;
            } else {
                int sum = poly1.coef + poly2.coef;
                if (sum != 0) {
                    curr.next = new Node(sum, poly1.exp);
                    poly1 = poly1.next;
                    poly2 = poly2.next;
                }
            }
            curr = curr.next;
        }

        // Append remaining terms from poly1 or poly2 if any
        while (poly1 != null) {
            curr.next = new Node(poly1.coef, poly1.exp);
            poly1 = poly1.next;
            curr = curr.next;
        }

        while (poly2 != null) {
            curr.next = new Node(poly2.coef, poly2.exp);
            poly2 = poly2.next;
            curr = curr.next;
        }

        return dummyHead.next; // Skip the dummy head node
    }

    public static void printPolynomial(Node poly) {
        Node curr = poly;
        while (curr != null) {
            System.out.print(curr.coef + "x^" + curr.exp);
            curr = curr.next;
            if (curr != null) {
                System.out.print(" + ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create polynomial 1: 3x^2 + 2x + 1
        Node poly1 = new Node(3, 2);
        poly1.next = new Node(2, 1);
        poly1.next.next = new Node(1, 0);

        // Create polynomial 2: 5x^1 + 4x^0
        Node poly2 = new Node(5, 1);
        poly2.next = new Node(4, 0);

        Node result = addPolynomials(poly1, poly2);
        System.out.print("Poly1: ");
        printPolynomial(poly1);
        System.out.print("Poly2: ");
        printPolynomial(poly2);
        System.out.print("Result: ");
        printPolynomial(result);
    }
}