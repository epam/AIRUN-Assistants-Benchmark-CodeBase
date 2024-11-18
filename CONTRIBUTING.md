# Contributing to AI / RUN <sup>TM</sup> Assistants Benchmark CodeBase

Thank you for your interest in contributing to AI / RUN <sup>TM</sup> Engineering Benchmark! We welcome
contributions from the community to help improve and grow this benchmark.

## Getting Started

- Fork the repository on GitHub
- Clone your forked repository to your local machine
- For tests running and editing you can use any IDE or a text editor i.e. Visual Studio or Visual Studio for .NET code and IntelliJ Idea for java. However as the tests are aimed at verifying behavior of code assistants you will have to use the IDE that supports the code assistant that you want to test (i.e. GitHub Copilot in Visual Studio)

## How to Contribute

1. Check the issue tracker for open issues or create a new one to discuss your idea.
2. Once approved, create a branch for your contribution.
3. Make your changes, following our style guidelines.
4. Write or update tests as necessary.
5. Ensure all tests pass.
6. Submit a pull request.

## Submitting a Pull Request

1. Push your changes to your forked repository.
2. Navigate to the original repository and create a pull request.
3. Provide a clear description of the changes and their purpose.
4. Wait for a maintainer to review your pull request.

## Reporting Bugs

- Use the GitHub issue tracker to report bugs.
- Describe the bug in detail, including steps to reproduce.
- Include any relevant code snippets or error messages.

## Suggesting Enhancements

- Use the GitHub issue tracker to suggest enhancements.
- Clearly describe the enhancement and its potential benefits.
- Be open to discussion and feedback from maintainers and other contributors.

## Style Guidelines

### General Rules

- As the test try to represent various cases that can arise in real development you can use any reasonable programming style that you see fit.
- Respect everyone - usually people have good reasons to think what they think and do what they do. Don't blame anyone without attempting to figure out reasons
- Try to be as consistent as possible (code style, structure of folders etc.)
- One problem should generally reside in it's own {problem-name} folder. Don't try to combine problems in a same folder as it may confuse testers - respect their work and please give them maximum context to minimize their learning curve on your mini-project.

### Directory Structure

Try to stick to the following repository structure:
<pre>
├── { category-name } // take this from PowerPoint i.e. code-bug-fixing
│   ├── { problem-name } // make a good problem name but concise i.e. wrong-conditional-statement
│   │   ├── { language-name } // language name i.e. java
│   │   │   ├── {IDE Name}
</pre>
i.e.
<pre>
├── static-data-generation
│   ├── mime-types
│   │   ├── C#
│   │   │   ├── VisualStudio
│   │   │   │   ├── ...
│   │   │   ├── VSCode
│   │   │   │   ├── ...
</pre>
---

This document is subject to change. Contributors are encouraged to check for
updates regularly.

<p align="center">
  EPAM and EPAM AI/RUN <sup>TM</sup> are trademarks of EPAM Systems, Inc. 
</p>
