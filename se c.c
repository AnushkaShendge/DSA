#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
struct TreeNode {
char data;
struct TreeNode* left;
struct TreeNode* right;
};
typedef struct TreeNode TreeNode;
bool isOperator(char c) {
return (c == '+' || c == '-' || c == '*' || c == '/');
}
TreeNode* createNode(char value) {
TreeNode* node = (TreeNode*)malloc(sizeof(TreeNode));
node->data = value;
node->left = NULL;
node->right = NULL;
return node;
}
// Function to construct an expression tree from a postorder traversal
TreeNode* constructExpressionTree(char postfix[]) {
TreeNode* stack[100];
int top = -1;
for (int i = 0; postfix[i] != '\0'; i++) {
TreeNode* node = createNode(postfix[i]);
if (!isOperator(postfix[i])) {
stack[++top] = node;
} else {
node->right = stack[top--];
node->left = stack[top--];
stack[++top] = node;
}
}
return stack[top];
}
// Function to perform in-order traversal and print the result in infix notation without parentheses
void printInfix(TreeNode* node) {
if (node) {
printInfix(node->left);
printf("%c", node->data);
printInfix(node->right);
}
}
// Function to free the dynamically allocated memory for the tree
void freeTree(TreeNode* node) {
if (node) {
freeTree(node->left);
freeTree(node->right);
free(node);
}
}
int main() {
char postfix[100];
printf("Enter a postfix expression: ");
scanf("%s", postfix);
TreeNode* root = constructExpressionTree(postfix);
printf("Infix Expression: ");
printInfix(root);
printf("\n");
// Free dynamically allocated memory
freeTree(root);
return 0;
