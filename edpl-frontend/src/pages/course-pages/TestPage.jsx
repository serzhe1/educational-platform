import { useState } from 'react';
import { Layout, Row, Col, Card, Button } from 'antd';

const { Content } = Layout;

const TestPage = () => {
  const questions = [
    {
      question: 'Какой год был основан Рим?',
      answers: ['753 до н.э.', '44 до н.э.', '1 н.э.'],
      correctAnswer: '753 до н.э.',
    },
    {
      question: 'В каком году произошла Октябрьская революция?',
      answers: ['1917', '1921', '1914'],
      correctAnswer: '1917',
    },
    {
      question: 'Кто первым сформулировал закон всемирного тяготения?',
      answers: ['Исаак Ньютон', 'Альберт Эйнштейн', 'Томас Эдисон'],
      correctAnswer: 'Исаак Ньютон',
    },
  ];

  const [currentQuestionIndex, setCurrentQuestionIndex] = useState(0);
  const [selectedAnswer, setSelectedAnswer] = useState('');

  const handleAnswerSelect = (answer) => {
    setSelectedAnswer(answer);
  };

  const handleNextQuestion = () => {
    if (selectedAnswer !== '') {
      setSelectedAnswer('');
      setCurrentQuestionIndex(currentQuestionIndex + 1);
    }
  };

  const handleFinishTest = () => {
    // if (selectedAnswer !== '') {
    //   setSelectedAnswer('');
    //   setCurrentQuestionIndex(currentQuestionIndex + 1);
    // }
  };

  const currentQuestion = questions[currentQuestionIndex];

  return (
    <Layout>
      <Content style={{ padding: '50px' }}>
        <Row gutter={[16, 16]}>
          {questions.map((question, index) => (
            <Col span={16} key={index}>
              <Card title={`Вопрос ${index + 1}`}>
                <p>{question.question}</p>
                {question.answers.map((answer, answerIndex) => (
                  <Button
                    key={answerIndex}
                    type={selectedAnswer === answer ? 'primary' : 'default'}
                    onClick={() => handleAnswerSelect(answer)}
                    style={{ margin: '10px' }}
                  >
                    {answer}
                  </Button>
                ))}
                {currentQuestionIndex < questions.length - 1 ? (
                  <Button
                    type="primary"
                    disabled={selectedAnswer === ''}
                    onClick={handleNextQuestion}
                    style={{ margin: '10px' }}
                  >
                    Далее
                  </Button>
                ) : (
                  <Button
                    type="primary"
                    disabled={selectedAnswer === ''}
                    onClick={handleFinishTest}
                    style={{ margin: '10px' }}
                  >
                    Завершить
                  </Button>
                )}
              </Card>
            </Col>
          ))}
        </Row>
      </Content>
    </Layout>
  );
};

export default TestPage;